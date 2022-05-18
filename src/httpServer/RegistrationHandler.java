package httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RegistrationHandler implements HttpHandler {
    private UserDataBase userDataBase;

    public RegistrationHandler(UserDataBase userDataBase) {
        this.userDataBase = userDataBase;
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        RequestBodyExtractor bodyExtractor = new RequestBodyExtractor();
        FileReader fileReader = new FileReader();
        String htmlFile = fileReader.read("/Users/egor/IdeaProjects/HTTP.Test/src/File2.html");
        OutputStream responseBody = exchange.getResponseBody();
        User response = bodyExtractor.extract(exchange);
        userDataBase.add(response);
        String text = response.getId() + "<br>" + response.getNickName() + "<br>" + response.getMail() + "<br>" + response.getPassword();
        htmlFile = String.format(htmlFile, response.getId(), text);
        exchange.sendResponseHeaders(200, htmlFile.length());
        responseBody.write(htmlFile.getBytes(StandardCharsets.UTF_8));
//        responseBody.write(text.getBytes(StandardCharsets.UTF_8));
        System.out.println(text);

        responseBody.flush();
        responseBody.close();
    }
}
