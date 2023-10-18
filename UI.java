/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/18/2023
 */

public class UI {
    private static final String[] USER_CAM = {"Cam", "Osterholt", "banana@osterholt.us", "p33y0urp@nt$"};
    public static void main(String args[]) {
        UI ui  = new UI();
        ui.run();
    }
    public static void run() {
        if(AppFacade.login("plante@gmail.com", "password4")) {
            System.out.println("Successfully logged in");
            System.out.println(AppFacade.getCurrentUser().getFirstName());
        } else {
            System.out.println("Not able to login");
        }

        // AppFacade.signUp("Portia", "Plante", "plante@gmail.com", "password4");
        // AppFacade.logOut();
      
        //TODO:
        //ADD USER with data above
        //Signup
        //Add to json file - test
        //Make sure we can save
    }
}
