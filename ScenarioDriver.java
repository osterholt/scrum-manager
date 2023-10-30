import java.util.HashMap;
import java.util.Scanner;
/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/30/2023
 */

public class ScenarioDriver {
    private static Scanner scnr;
    //User Info: {Atticus, Madden, amadden@email.sc.edu, password}
   
    public static void main(String[] args) {
        run();
    }

     /*
     *     Your name is Atticus Madden.
            - You currently work for Code Mission Possible - A company who works on creating software solutions for clean energy.
            - You are the SCRUM Manager for 3 different projects (Electric Missiles, Soap Free Washers, and Air Computers)
            - Open Electric Missiles
            - Add a new task "Initialize super algorithm to detonate at warp speed". Assign the task to Jeff Goldblum.
            - Add a comment to the task "Avoid civilians Jeff!"
            - Move the existing task of "Curve the metal to make a cylindrical shape" to the 'Doing' column. This task has the existing comments of "Not cylindrical enough" - by Jeff, and "What's a cylinder" by Atticus Finch.  Reply to Jeff's comment and say "How about you do it jeff", and re-assign the task from yourself to Jeff.
            - Add a new column called "Abandoned"
            - Move an existing task "Make impossible burger possible" which doesn't really relate to the project purpose to "Abandoned"
            - Now print the scrum board to a txt file.... make it pretty.
     */

    private static void run() {
        int choice = 0;
        while(choice != 9) {
            scnr = new Scanner(System.in);
            System.out.print("Enter selection:" 
                             + "1. Create New User"
                             + "2. Login"
                             + "3. Create New Company"
                             + "9. Quit");
            choice = Integer.parseInt(scnr.nextLine());
            HashMap<String, String> info = null;
            switch(choice) {
                case 1:
                    info = getNewUserData();
                    AppFacade.signUp(info.get("First Name"), info.get("Last Name"), info.get("Email"), info.get("Password"));
                    break;
                case 2:
                    info = getExistingData();
                    AppFacade.login(info.get("Email"), info.get("Password"));
                    break;
                case 3:
                    
                    break;
                case 9:
                    return;
            }

        }


    }


    private static HashMap<String, String> getNewUserData() {
        System.out.print("Enter first name:");
        String firstName = scnr.nextLine();

        System.out.print("Enter last name:");
        String lastName = scnr.nextLine();
        
        System.out.print("Enter email:");
        String email = scnr.nextLine();
        
        System.out.print("Enter password:");
        String password = scnr.nextLine();

        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("First Name", firstName);
        ret.put("Last Name", lastName);
        ret.put("Email", email);
        ret.put("Password", password);
        return ret;
    }
    private static HashMap<String, String> getExistingData() {
        System.out.print("Enter email:");
        String email = scnr.nextLine();
        
        System.out.print("Enter password:");
        String password = scnr.nextLine();

        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("Email", email);
        ret.put("Password", password);
        return ret;
    }
}
