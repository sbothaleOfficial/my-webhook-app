package com.webhook.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.webhook.model.Person;
import com.webhook.repository.PersonRepository;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class PostHandler implements HttpHandler {

    private static Map<String, String> data = new HashMap<>();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("POST")) {
            InputStream requestBody = exchange.getRequestBody();
            byte[] buffer = new byte[requestBody.available()];
            requestBody.read(buffer);

            // Print the request payload to the console
            System.out.println(new String(buffer));

            // Parse the request payload and update the person object
            String payload = new String(buffer);
            String[] values = payload.split(",");
            Person person = PersonRepository.getPerson("John Doe");
            for (String value : values) {
                String[] parts = value.split(":");
                String key = parts[0].trim();
                String val = parts[1].trim();
                if (key.equals("name")) {
                    person.setName(val);
                } else if (key.equals("id")) {
                    person.setId(val);
                } else if (key.equals("location")) {
                    person.setLocation(val);
                }
            }

            // Save the data to memory
            data.put("data", payload);

            String acknowledgement = "Received POST request and processed successfully";
            exchange.sendResponseHeaders(200, acknowledgement.getBytes().length);

            OutputStream responseBody = exchange.getResponseBody();
            responseBody.write(acknowledgement.getBytes());
            responseBody.close();
        } else {
            exchange.sendResponseHeaders(405, 0);
            OutputStream responseBody = exchange.getResponseBody();
            responseBody.close();
        }
    }
}
