package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import jdk.javadoc.doclet.Taglet;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class UserHandler implements HttpHandler {
    private UserDataBase userDataBase;



    @Override
    public void handle(HttpExchange exchange) throws IOException {
        OutputStream responseBody = exchange.getResponseBody();
        String line = exchange.getRequestURI().toString();
        String[] split = line.split("/");
        String userId = split[2];
        for (int i = 0; i < userDataBase.size(); i++) {
            System.out.println(i);
            if (userId.equals(userDataBase.get(i).getId())){
                String response = userDataBase.get(i).getNickName();
                exchange.sendResponseHeaders(302, response.length());
                responseBody.write(response.getBytes(StandardCharsets.UTF_8));
            }
        }

        responseBody.flush();
        responseBody.close();

    }
}
