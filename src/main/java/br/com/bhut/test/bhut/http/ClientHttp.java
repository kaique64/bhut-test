package br.com.bhut.test.bhut.http;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {

    /**
     * Function responsible to make the HTTP request (GET)
     * @param url the url from the service
     */
    private HttpResponse<String> get(String url) {
        try {
            URI address = URI.create(url);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response;
        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Function responsible to make the HTTP request (POST)
     * @param url the url from the service
     * @param body the POST body in JSON format
     */
    public HttpResponse<String> post(String url, JSONObject body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    /**
     * Function responsible to get the response from HTTP request
     * @param url the url from the service
     */
    public String searchData(String url) {
        HttpResponse<String> response = get(url);

        return response.body();
    }

}
