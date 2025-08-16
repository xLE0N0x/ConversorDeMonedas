package dev.conversor.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestAPI {
    private static final String URL_BASE = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "12cd4a703117a15e34146c43";

    public static String obtenerDatosDivisa(String divisaBase, String divisaTarget) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + API_KEY + "/pair/" + divisaBase + "/" + divisaTarget))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
