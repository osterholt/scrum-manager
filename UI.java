/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/18/2023
 */

public class UI {
    public static void main(String args[]) {
        UI ui  = new UI();
        ui.run();
    }
    public void run() {
        if(AppFacade.login("plante@gmail.com", "password4")) {
            System.out.println("Successfully logged in");
            System.out.println(AppFacade.getCurrentUser().getFirstName());
        } else {
            System.out.println("Not able to login");
        }

        // AppFacade.signUp("Portia", "Plante", "plante@gmail.com", "password4");
        // AppFacade.logOut();

    }
}
