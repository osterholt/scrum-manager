import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/10/2023
 */

public class AppFacade {
    private static User activeUser;
    private static Board activeBoard;
    private static AppFacade appFacade;

    private AppFacade() {
        activeUser = null;
        activeBoard = null;
    }

    public static AppFacade getInstance() {
        if(appFacade == null)
            appFacade = new AppFacade();
        return appFacade;
    }

    public static User getActiveUser() {
        if(activeUser == null) {
            System.out.println("No User Logged In.");
            return null;
        }
        return activeUser;
    }

    public static Board getActiveBoard() {
        if(activeBoard == null) {
            System.out.println("No Board Selected.");
            return null;
        }
        return activeBoard;
    }

    public static boolean login(String username, String password) {
        activeUser = LoginManager.getUser(username, password);
        if(activeUser == null){
            return false;
        }
        return true;
    }

    public static User getCurrentUser(){
        return activeUser;
    }

    public static UUID signUp(String firstName, String lastName, String email, String password) {
        User user = new User(firstName, lastName, email, password);
        LoginManager.getInstance().addUser(user);
        return user.getId();
    }

    public static User getUser(UUID id) {
        return LoginManager.getUser(id);
    }

    public static void logOut() {
        LoginManager.saveUsers();
    }

}
