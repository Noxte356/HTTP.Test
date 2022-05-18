package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RegisterHtmlFormHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        FileReader htmlFile = new FileReader();
        OutputStream responseBody = exchange.getResponseBody();
        String response = htmlFile.read("/Users/egor/IdeaProjects/HTTP.Test/src/Test.html");
        exchange.sendResponseHeaders(200, response.length());

        responseBody.write(response.getBytes(StandardCharsets.UTF_8));

        responseBody.flush();
        responseBody.close();
    }
}
