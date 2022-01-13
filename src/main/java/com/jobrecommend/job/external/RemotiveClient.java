package com.jobrecommend.job.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobrecommend.job.entity.Item;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RemotiveClient {
    private static String url_template =
            "https://remotive.io/api/remote-jobs?";
    private static final String DEFAULT_KEYWORD = "developer";

    public List<Item> search(String category, String company_name, String search_keyword, String limit) {
        if (search_keyword == null) {
            search_keyword = DEFAULT_KEYWORD;
        }
        url_template += String.format("search=%s", search_keyword);
        if (limit != null) {
            url_template += String.format("&limit=%s", limit);
        } else {
            url_template += String.format("&limit=5");
        }
        if (category != null) {
            url_template += String.format("&category=%s", category);
        }
        if (company_name != null) {
            url_template += String.format("&company_name=%s", company_name);
        }

        try {
            search_keyword = URLEncoder.encode(search_keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = String.format(url_template, search_keyword, limit);

        CloseableHttpClient httpclient = HttpClients.createDefault();

        // Create a custom response handler
        ResponseHandler<List<Item>> responseHandler = response -> {
            if (response.getStatusLine().getStatusCode() != 200) {
                return Collections.emptyList();
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                return Collections.emptyList();
            }
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(entity.getContent(), Item[].class));
        };

        try {
            return httpclient.execute(new HttpGet(url), responseHandler);
        } catch (IOException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
