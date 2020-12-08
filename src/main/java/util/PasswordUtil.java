package util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    public static boolean comparePassword(String hashed, String unhashed){
        return BCrypt.checkpw(unhashed, hashed);
    }

    public static String getHashedPassword(String string){
        return BCrypt.hashpw(string, BCrypt.gensalt());
    }



}
