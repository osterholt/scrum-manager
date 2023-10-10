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
        // TODO: init
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

    private boolean login() { //TODO: Determine parameters
        return true;
    }

    private boolean signUp() {
        return true;
    }


}
