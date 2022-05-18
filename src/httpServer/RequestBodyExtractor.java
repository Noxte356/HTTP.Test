package httpServer;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RequestBodyExtractor {
    public User extract(HttpExchange exchange) throws IOException {
        User user = new User();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        exchange.getRequestBody()));

        String line = reader.readLine();
        String[] userDataBase = line.split("&");
        user.setId(userDataBase[0]);
        user.setNickName(userDataBase[1]);
        user.setMail(userDataBase[2]);
        user.setPassword(userDataBase[3]);
        return user;
    }
}
