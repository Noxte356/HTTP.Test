package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HttpHandler2 implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        OutputStream responseBody = exchange.getResponseBody();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                       exchange.getRequestBody() ));
        String response = "";
        String line;
        while((line = reader.readLine()) !=null) {
            response = line;
        }
        exchange.sendResponseHeaders(200, response.length());
        responseBody.write(response.getBytes(StandardCharsets.UTF_8));

        responseBody.flush();
        responseBody.close();
    }
}
