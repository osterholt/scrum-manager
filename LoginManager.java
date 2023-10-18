import java.util.ArrayList;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * @author Cam Osterholt & Evelyn Ellis
 * @version v2.0
 * Date: 10/17/2023
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
        // check if email is already in user list
        for (User user : userList) {
            if(user.getEmail().equals(email)){
                return false;
            }    
        }
        // check if email is valid
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean checkPassword(String password) {
        // check for size
        return password.length()<8;
    }
    public boolean addUser(String firstName, String lastName, String email, String password) {
        User user = new User(firstName, lastName, email, password);
        return userList.add(user);
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
    public static boolean saveUsers() {
        return DataWriter.saveUsers();
    }
    public static User getUser(String email, String password) {
        for(User user : userList) {
            if(user.getEmail().equals(email) && user.isPassword(password))
                return user;
        }
        return null;
    }
}

