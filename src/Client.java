import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("mail.ru",80);
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            writer.write("GET /?key1=value1&key2=value2 HTTP/1.1\n");
            writer.write("Host: mail.ru:80\n");
            writer.write("\n");
            writer.flush();
            String line;
                while((line = reader.readLine())!=null){
                    System.out.println(line);
                }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
