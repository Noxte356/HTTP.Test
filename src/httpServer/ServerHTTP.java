package httpServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ServerHTTP {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext("/", new  TestHttpHandler());
        server.setExecutor(Executors.newFixedThreadPool(5));
        server.createContext("/register", new HttpHandler2());
        server.start();
    }


}
