package app;

import java.util.HashMap;
import java.util.Hashtable;

import entity.User;

public class AppContext {

    static User user;

    static HashMap<String, Object> dictionary;

    static {
        dictionary = new HashMap<String, Object>();
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

    public static void clear() {
        AppContext.user = null;
        AppContext.dictionary = new HashMap<String, Object>();
    }

    public static boolean contains(String key){
        return AppContext.dictionary.containsKey(key);
    }

}
