package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpStatusChecker {
    private static final String URL = "https://http.cat/";
    private final HttpClient client = HttpClient.newHttpClient();

    public String getStatusImage(int code){

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + code +".jpg"))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 404){
                throw new Exception(" -> you have used invalid code <-");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return URL + code +".jpg";
    }
}
