package httpServer;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase {
    private List<User> usersDataBase = new ArrayList<>();

    public void add(User user) {

        usersDataBase.add(user);
    }

    public User get(int numb){
        return usersDataBase.get(numb);
    }

    public int size(){
        return usersDataBase.size();
    }


}
