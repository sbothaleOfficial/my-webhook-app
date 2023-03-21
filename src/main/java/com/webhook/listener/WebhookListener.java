package com.webhook.listener;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class WebhookListener {

    public static void startServer(int port, Map<String, HttpHandler> handlers) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(null);

        // Register the handlers for each HTTP method
        for (String method : handlers.keySet()) {
            String path = "/" + method.toLowerCase(); // Set a unique context path for each handler
            server.createContext(path, handlers.get(method));
        }

        server.start();
        System.out.println("Server listening on port " + port);
    }

}
