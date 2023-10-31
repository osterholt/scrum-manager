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
    public void run() {
        

        // AppFacade.signUp("Portia", "Plante", "plante@gmail.com", "passwordpaswwrod");
        // AppFacade.logOut();
        AppFacade.getInstance().signUp("joshua", "dietrich", "jdd10@gmail.com", "123456789");
        AppFacade.getInstance().logOut();
        if(AppFacade.getInstance().login("plante@gmail.com", "passwordpaswwrod")) {
            System.out.println("Successfully logged in");
            System.out.println(AppFacade.getInstance().getCurrentUser().getFirstName());
        } else {
            System.out.println("Not able to login");
        }
      
        //TODO:
        //ADD USER with data above
        //Signup
        //Add to json file - test
        //Make sure we can save
    }
}
