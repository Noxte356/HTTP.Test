package httpServer;

import java.io.*;

public class FileReader {
    public String read(String filePath) throws IOException {
        String htmlFile = "";
        File file = new File(filePath);
        java.io.FileReader fileReader = new java.io.FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;
        while ((line = reader.readLine()) != null) {
            htmlFile = htmlFile + "\n" + line;
        }
        return htmlFile;
    }
}
