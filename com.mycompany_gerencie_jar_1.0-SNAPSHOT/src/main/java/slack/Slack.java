package slack;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.h2.util.json.JSONObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jvsdi
 */
public class Slack {
    
    private static HttpClient client = HttpClient.newHttpClient();
    private static final String URL = "https://hooks.slack.com/services/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";
//    public static void sendMessage(JSONObject content) throws IOException, InterruptedException{
//        
//        HttpRequest request = HttpRequest.newBuilder(
//                URI.create(URL))
//                .header("accept", "aplication/json")
//                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
//                .build();
//
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        
//        System.out.println(String.format("Status: %s", response.statusCode()));
//        System.out.println(String.format("Response: %s", response.body()));
//    }


    static void sendMessage(org.json.JSONObject json)  throws IOException, InterruptedException{
        
        HttpRequest request = HttpRequest.newBuilder(
                URI.create(URL))
                .header("accept", "aplication/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
//        System.out.println(String.format("Status: %s", response.statusCode()));
//        System.out.println(String.format("Response: %s", response.body()));
    }
    
}
