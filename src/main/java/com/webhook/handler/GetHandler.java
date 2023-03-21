package com.webhook.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.webhook.model.Person;
import com.webhook.repository.PersonRepository;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;

public class GetHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("GET")) {
            // Get the name parameter from the URL
            String[] pathParts = exchange.getRequestURI().getPath().split("/");
            String name = pathParts[pathParts.length - 1];

            // Get the person object from the repository
            Person person = PersonRepository.getPerson(name);

            if (person == null) {
                // Return 404 if person is not found
                exchange.sendResponseHeaders(404, 0);
            } else {
                // Convert the person object to a JSON string
                JSONObject json = new JSONObject(person);
                String response = json.toString();

                // Set the response headers and write the response body
                exchange.getResponseHeaders().set("Content-Type", "application/json");
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream responseBody = exchange.getResponseBody();
                responseBody.write(response.getBytes());
                responseBody.close();
            }
        } else {
            exchange.sendResponseHeaders(405, 0);
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.close();
        }
    }

}