package Test;

import httpServer.Singleton;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Singleton.getTestObj();
        QQ qq = new QQ();
        qq.print();

    }
}
