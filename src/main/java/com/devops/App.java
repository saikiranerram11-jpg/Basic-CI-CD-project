package com.devops;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws IOException {

        int port = 8081;

        HttpServer server = HttpServer.create(
                new InetSocketAddress("0.0.0.0", port),
                0
        );

        server.createContext("/", exchange -> {

            String response =
                    "Hello from Basic CI/CD Project!<br>" +
                    "Deployed using Jenkins + Docker + AWS EC2.";

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/html");

            exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
            );

            try (OutputStream outputStream = exchange.getResponseBody()) {
                outputStream.write(response.getBytes());
            }
        });

        server.start();

        System.out.println(
                "Application running on port " + port
        );
    }
}
