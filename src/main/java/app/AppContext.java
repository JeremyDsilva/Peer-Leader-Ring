package app;

import entity.User;

public class AppContext {

    static User user;

    public static User getUser(){
        return AppContext.user;
    }

    public static User setUser(User user){
        return AppContext.user = user;
    }
    
}
