import java.util.ArrayList;
/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/10/2023
 */

public class LoginManager {
    private static ArrayList<User> userList;
    private static LoginManager loginManager;

    public static LoginManager getInstance() {
        if(loginManager == null) 
            loginManager = new LoginManager();
        return loginManager;
    }

    private LoginManager() {
        //TODO: init
    }

    public static boolean checkEmail(String email) {
        return true;
    }
    public static boolean checkPassword(String password) {
        return true;
    }
    public boolean addUser(User newUser) {
        return true;
    }
}
