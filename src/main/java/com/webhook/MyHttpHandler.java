package com.webhook;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class MyHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        if (requestMethod.equalsIgnoreCase("POST")) {
            InputStream requestBody = exchange.getRequestBody();
            byte[] buffer = new byte[requestBody.available()];
            requestBody.read(buffer);

            // Print the request payload to the console
            System.out.println(new String(buffer));

            exchange.sendResponseHeaders(200, 0);
        } else {
            exchange.sendResponseHeaders(405, 0);
        }

        OutputStream responseBody = exchange.getResponseBody();
        responseBody.close();
    }

}

