package com.webhook;


import java.io.IOException;

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
        WebhookListener.startServer(port);
    }

}

