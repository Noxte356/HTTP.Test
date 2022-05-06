package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class HttpHandler2 implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        OutputStream responseBody = exchange.getResponseBody();
        String line = "<p>Выполнено<p>";

        exchange.sendResponseHeaders(301, line.length());
        responseBody.write(line.getBytes(StandardCharsets.UTF_8));

        responseBody.flush();
        responseBody.close();
    }
}
