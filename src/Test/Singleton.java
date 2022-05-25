package httpServer;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    public static ArrayList<String> dataBase;

    private Singleton() {

    }
    public static ArrayList getTestObj(){
        if (dataBase == null){
            dataBase = new ArrayList<>();
        }
        return dataBase;
    }
    public static String ha(){
        dataBase.add("String");
        return dataBase.get(0);
    }
}
