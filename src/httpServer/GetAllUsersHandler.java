package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class GetAllUsersHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        OutputStream responseBody = exchange.getResponseBody();
//        exchange.sendResponseHeaders(200, response.length());
//        responseBody.write(response.getBytes(StandardCharsets.UTF_8));

        responseBody.flush();
        responseBody.close();
    }
}
