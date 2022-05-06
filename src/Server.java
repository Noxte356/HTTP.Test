
import com.sun.net.httpserver.HttpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            while (true) {
                ServerSocket serverSocket = new ServerSocket(3333);
                System.out.println("Server Started");

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted");

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream()));
                OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
//                while (!reader.ready()) {
//                    System.out.println();
//                }
                while (reader.ready()) {
                    System.out.println(reader.readLine());
                }
                writer.write("HTTP/1.1 200 OK" + "\n");
                writer.write("Content-Type: text/html; charset=utf-8" + "\n");
                writer.write("\n");
                writer.write("<b><p>hello world!</p></b>" + "\n");
                writer.flush();
                reader.close();
                writer.close();
                serverSocket.close();
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
