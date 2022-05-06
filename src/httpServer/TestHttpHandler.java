package httpServer;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TestHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = "";
        File file = new File("/Users/egor/IdeaProjects/HTTP.Test/src/Test.html");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);


        OutputStream responseBody = exchange.getResponseBody();
        String line;
        while((line = reader.readLine()) !=null) {
            response = response + "\n" + line;
        }
        exchange.sendResponseHeaders(301, response.length());
        responseBody.write(response.getBytes(StandardCharsets.UTF_8));

        responseBody.flush();
        responseBody.close();
    }
}
