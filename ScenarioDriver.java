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
        char choice = ' ';
        while(choice != 'Z') {
            scnr = new Scanner(System.in);
            System.out.print("\nA. Enter User\n"
                            + "B. Enter Company\n"
                            + "C. Enter Board\n"
                            + "D. Enter Task\n"
                            + "Z. Quit\n"
                            + "Enter selection: ");
            choice = scnr.nextLine().charAt(0);
            
            switch(choice) {
                case 'A':
                    login();
                    break;
                case 'B':
                    company();
                    break;
                case 'C':
                    break;
                case 'E':
                    
                case 9:
                    return;
            }

        }


    }

    private static void login() {
        System.out.print("\nA. Login\n"
                             + "B. Create New User\n"
                             + "C. View User\n"
                             + "Z. Exit to Menu\n"
                             + "Enter selection: ");
        char choice = scnr.nextLine().charAt(0);
        HashMap<String, String> info = null;
        switch(choice) {
            case 'A':
                info = getExistingData();
                AppFacade.login(info.get("Email"), info.get("Password"));
                break;
            case 'B':
                info = getNewUserData();
                AppFacade.signUp(info.get("First Name"), info.get("Last Name"), info.get("Email"), info.get("Password"));
                break;
            case 'C':
                try{
                    System.out.println("Active User: " + AppFacade.getActiveUser().toString());
                }
                catch (Exception e){
                    System.out.println("No User Logged in.");
                }
                break;
            case 'Z':
                return;
        }
    }

    private static void company() {
        System.out.print("\nA. Set Active Company\n"
                       + "B. Create New Company\n"
                       + "C. View Active Company\n"
                       + "Z. Exit to Menu\n"
                       + "Enter selection: "); 
        char choice = scnr.nextLine().charAt(0);
        String name = null;
        switch(choice) {
            case 'A':
                System.out.print("Enter company name: ");
                name = scnr.nextLine();
                if(!AppFacade.setActiveCompany(name)) 
                    System.out.println("Company not found.");
                break;
            case 'B':
                System.out.print("Enter company name: ");
                name = scnr.nextLine();
                CompanyManager.getInstance().addCompany(new Company(name));
                break;
            case 'C':
                try{
                    System.out.println("Active Company: " + AppFacade.getActiveCompany().toString());
                }
                catch (Exception e){
                    System.out.println("No Active Company.");
                }
                break;
            case 'Z':
                return;
        }
    }


    private static HashMap<String, String> getNewUserData() {
        System.out.print("Enter first name: ");
        String firstName = scnr.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scnr.nextLine();
        
        System.out.print("Enter email: ");
        String email = scnr.nextLine();
        
        System.out.print("Enter password: ");
        String password = scnr.nextLine();

        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("First Name", firstName);
        ret.put("Last Name", lastName);
        ret.put("Email", email);
        ret.put("Password", password);
        return ret;
    }

    private static HashMap<String, String> getExistingData() {
        System.out.print("Enter email: ");
        String email = scnr.nextLine();
        
        System.out.print("Enter password: ");
        String password = scnr.nextLine();

        HashMap<String, String> ret = new HashMap<String, String>();
        ret.put("Email", email);
        ret.put("Password", password);
        return ret;
    }
}
