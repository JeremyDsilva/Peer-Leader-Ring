package app;

import entity.User;

public class AppContext {

    static User user;

    public static User getUser(){
        return AppContext.user;
    }

    public static void setUser(User user){
        AppContext.user = user;
    }
    
}
