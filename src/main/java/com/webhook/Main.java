package com.webhook;

import com.sun.net.httpserver.HttpHandler;
import com.webhook.listener.WebhookListener;
import com.webhook.handler.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        int port = 8000;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid port number, using default " + port);
            }
        }

        Map<String, HttpHandler> handlers = new HashMap<>();
        handlers.put("POST", new PostHandler());
        handlers.put("GET", new GetHandler());

        WebhookListener.startServer(port, handlers);
    }

}