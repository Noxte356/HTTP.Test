package httpServer;

import java.util.ArrayList;

public class UserDataBase {
    private static ArrayList<User> usersList;

    private UserDataBase() {
    }

    public static ArrayList<User> getObj(){
        if (usersList == null){
            usersList = new ArrayList<>();
        }
        return usersList;
    }

    public static void add(User user) {

        usersList.add(user);
    }

    public static User get(int numb){
        return usersList.get(numb);
    }

    public static int size(){
        return usersList.size();
    }


}
