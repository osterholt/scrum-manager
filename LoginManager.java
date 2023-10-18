import java.util.ArrayList;
import java.util.UUID;
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
        userList = DataWriter.getUsers();
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
    public static User getUser(UUID id) {
        for(User user : userList) {
            if(id.equals(user.getId()))
                return user;
        }
        Test.print("No User Found.");
        return null;
    }
    public ArrayList<User> getUsers() {
        return userList;
    }
    public boolean saveUsers() {
        return DataWriter.saveUsers();
    }
}
