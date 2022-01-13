package com.jobrecommend.job.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jobrecommend.job.db.MySQLConnection;
import com.jobrecommend.job.entity.Item;
import com.jobrecommend.job.entity.ResultResponse;
import com.jobrecommend.job.external.RemotiveClient;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ObjectMapper mapper = new ObjectMapper();
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.setStatus(403);
            mapper.writeValue(response.getWriter(), new ResultResponse("Session Invalid"));
            return;
        }
        String userId = request.getParameter("user_id");

        String category = request.getParameter("category");
        String companyName = request.getParameter("company_name");
        //int limit = Integer.parseInt(request.getParameter("limit"));
        String limit = request.getParameter("limit");

        MySQLConnection connection = new MySQLConnection();
        Set<String> favoriteItemIds = connection.getFavoriteItemIds(userId);
        connection.close();

        RemotiveClient client = new RemotiveClient();
        //String itemsString = client.search(category, company_name,null, limit);
        List<Item> items = client.search(category, companyName, null, limit);

        for (Item item : items) {
            item.setFavorite(favoriteItemIds.contains(item.getId()));
        }

        response.setContentType("application/json");
        //response.getWriter().print(itemsString);
        mapper.writeValue(response.getWriter(), items);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
