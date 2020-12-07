package app;

import java.util.Dictionary;

import entity.User;

public class AppContext {

    static User user;

    static Long groupId = null;

    static Dictionary<String, Object> dictionary;

    public static User getUser() {
        return AppContext.user;
    }

    public static void setUser(User user) {
        AppContext.user = user;
    }

    public static Object get(String value) {
        return AppContext.dictionary.get(value);
    }

    public static void put(String value, Object obj) {
        AppContext.dictionary.put(value, obj);
    }

}
