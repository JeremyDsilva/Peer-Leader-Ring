package app;

import java.util.Dictionary;
import java.util.Hashtable;

import entity.User;

public class AppContext {

    static User user;

    static Long groupId = null;

    static Dictionary<String, Object> dictionary;

    static {
        dictionary = new Hashtable<String, Object>();
    }

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

    public static void remove(String value) {
        AppContext.dictionary.remove(value);
    }

    public static Boolean userIsAdmin() {
        return AppContext.user.getUserRole().equals("admin");
    }

    public static Boolean userIsLeader() {
        return AppContext.user.getUserRole().equals("leader");
    }

    public static Boolean userIsStudent() {
        return AppContext.user.getUserRole().equals("student");
    }

}
