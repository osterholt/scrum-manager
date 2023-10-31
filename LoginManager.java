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
        if(userList == null)
            userList = new ArrayList<User>();
    }

    public static boolean checkEmail(String email) {
        // check if email is already in user list
        if(userList!=null){
        for (User user : userList) {
            if(user.getEmail().equals(email)){
                return false;
            }    
        }
        }
        // check if email is valid
        String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Checks password that it is 8 or more characters.
     * @param password String to check
     * @return boolean if correct size
     */
    public static boolean checkPassword(String password) {
        return password.length() > 7;
    }

    /**
     * Adds a user to the master list.
     * @param user user to add
     * @return boolean if user was added.
     */
    public boolean addUser(User user) {
        if(user != null)
            return userList.add(user);
        return false;
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

    /*
     * Has DataWriter save the users to json.
     */
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

