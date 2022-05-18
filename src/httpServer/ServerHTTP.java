package httpServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ServerHTTP {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        UserDataBase userDataBase = new UserDataBase();
        server.setExecutor(Executors.newFixedThreadPool(5));
        server.createContext("/", new RegisterHtmlFormHandler());
        server.createContext("/register", new RegistrationHandler(userDataBase));
        server.createContext("/allUsers", new GetAllUsersHandler());
        server.createContext("/user/", new UserHandler(userDataBase));
        server.start();
//        1) Красиво вывести на сайте, в тайтле должно быть id
//                2) при переходе на /users/{id}
//                3) выводить всех пользователей
    }


}
