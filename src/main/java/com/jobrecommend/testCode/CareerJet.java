package com.jobrecommend.testCode;

import java.util.*;

import com.careerjet.webservice.api.Client;
import org.json.JSONArray;
import org.json.JSONObject;

public class CareerJet {
    public static void main(String[] argss) {
//        Client c = new Client("en_GB");
//
//        Map<String, String> args = new HashMap<String, String>();
//        args.put("keywords", "java");
//        args.put("location", "london");
//
//        args.put("affid", "213e213hd12344552");
//
//        args.put("user_ip",    request.getRemoteAddr());
//        args.put("user_agent", request.getHeader("User-Agent"));
//        args.put("url",        request.getRequestURL().toString());
//
//        JSONObject results = (JSONObject) c.search(args);
//
//        // A list of jobs is returned
//        if (results.get("type").equals("JOBS")) {
//            JSONArray jobs = (JSONArray) results.get("jobs");
//            System.out.println("Number of results:" + results.get("hits"));
//            int index = 0;
//            while( index < jobs.size()) {
//                JSONObject job = (JSONObject) jobs.get(index);
//                System.out.println("URL         :" + job.get("url"));
//                System.out.println("TITLE       :" + job.get("title"));
//                System.out.println("COMPANY     :" + job.get("company"));
//                System.out.println("SALARY      :" + job.get("salary"));
//                System.out.println("DATE        :" + job.get("date"));
//                System.out.println("DESCRIPTION :" + job.get("description"));
//                System.out.println("SITE        :" + job.get("site"));
//                System.out.println("LOCATIONS   :" + job.get("locations"));
//                index++;
//            }
//        }
//
//        // The location was amiguous. Suggestions are returned.
//        // Add the location_id to the query to resolve the ambiguity.
//        if (results.get("type").equals("LOCATIONS")) {
//            System.out.println("Narrow down your location ");
//            System.out.println("Please specify a location");
//            JSONArray solvelocations = (JSONArray) results.get("solveLocations");
//            int index = 0;
//            while(index < solvelocations.size()) {
//                JSONObject location = (JSONObject) solvelocations.get(index);
//                System.out.println("NAME        :" + location.get("name"));
//                System.out.println("LOCATION ID :" + location.get("location_id"));
//                index++;
//            }
//        }
//
//        // An error occured. An error message is returned.
//        if (results.get("type").equals("ERROR")) {
//            System.out.println("An error occurred whilst processing the search query");
//            System.out.println("Error message    :" + results.get("ERROR"));
//        }


    }
}
