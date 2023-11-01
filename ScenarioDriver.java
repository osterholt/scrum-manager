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
        clearTerminal();
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
            printActive();
            System.out.print("A. User\n"
                            + "B. Company\n"
                            + "C. Board\n"
                            + "D. Column\n"
                            + "E. Task\n"
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
                    board();
                    break;
                case 'D':
                    column();
                    break;                    
                case 'Z':
                    AppFacade.getInstance().logOut();
                    return;
                default:
                    clearTerminal();
                    break;
            }
            // System.out.println("------------------------------------\n");
        }


    }

    private static void login() {
        clearTerminal();
        System.out.print("A. Login\n"
                             + "B. Create New User\n"
                             + "C. View User\n"
                             + "D. View all Users (DEBUG)\n"
                             + "Z. Exit to Menu\n"
                             + "Enter selection: ");
        char choice = scnr.nextLine().charAt(0);
        HashMap<String, String> info = null;
        switch(choice) {
            case 'A':
                clearTerminal();
                info = getExistingData();
                AppFacade.getInstance().login(info.get("Email"), info.get("Password"));
                break;
            case 'B':
                clearTerminal();
                info = getNewUserData();
                AppFacade.getInstance().signUp(info.get("First Name"), info.get("Last Name"), info.get("Email"), info.get("Password"));
                AppFacade.getInstance().login(info.get("Email"), info.get("Password"));
                break;
            case 'C':
                clearTerminal();
                try{
                    System.out.println("Active User: \n" + AppFacade.getInstance().getActiveUser().info());
                }
                catch (Exception e){
                    System.out.println("No User Logged in.");
                }
                break;
            case 'D':
                clearTerminal();
                LoginManager.getInstance().printUsers();
                break;
            case 'Z':
                clearTerminal();
                return;
        }
    }

    private static void company() {
        clearTerminal();
        System.out.print("A. Set Active Company\n"
                       + "B. Create New Company\n"
                       + "C. View Active Company\n"
                       + "Z. Exit to Menu\n"
                       + "Enter selection: "); 
        char choice = scnr.nextLine().charAt(0);
        String name = null;
        switch(choice) {
            // Set Active Company
            case 'A':
                clearTerminal();
                System.out.print("Enter company name: ");
                name = scnr.nextLine();
                if(!AppFacade.getInstance().setActiveCompany(name)) 
                    System.out.println("Company not found.");
                break;
            // New Company
            case 'B':
                clearTerminal();
                System.out.print("Enter company name: ");
                name = scnr.nextLine();
                CompanyManager.getInstance().addCompany(new Company(name));
                break;
            case 'C':
                clearTerminal();
                try{
                    System.out.println("Active Company: " + AppFacade.getInstance().getActiveCompany().toString());
                }
                catch (Exception e){
                    System.out.println("No Active Company.");
                }
                break;
            case 'Z':
                clearTerminal();
                return;
        }
    }

    private static void board() {
        clearTerminal();
        System.out.print("A. Open Board\n"
                             + "B. Create New Board\n"
                             + "C. View Active Board\n"
                             + "Z. Exit to Menu\n"
                             + "Enter selection: ");
        char choice = scnr.nextLine().charAt(0);
        String name = null;
        switch(choice) {
            // Open Board
            case 'A':
                clearTerminal();
                System.out.print("Enter board name: ");
                name = scnr.nextLine();
                if(!AppFacade.getInstance().setActiveBoard(name)) 
                    System.out.println("Board not found.");
                break;
            // Create Board
            case 'B':
                clearTerminal();
                System.out.print("Enter board name: ");
                name = scnr.nextLine();

                System.out.print("[O]pen or [P]rivate: ");
                char openChar = scnr.nextLine().charAt(0);
                boolean open = false;
                if(openChar == 'O')
                    open = true;

                AppFacade.getInstance().getActiveCompany().addBoard(new Board(name, open));

                AppFacade.getInstance().setActiveBoard(name);

                break;
            // Active Board
            case 'C':
                clearTerminal();
                try{
                    System.out.println("Active Board: " + AppFacade.getInstance().getActiveBoard().toString());
                }
                catch (Exception e){
                    System.out.println("No Active Board.");
                }
                break;
            case 'Z':
                clearTerminal();
                return;
        }
    }

    private static void column() {
        clearTerminal();
        System.out.print("A. View Tasks\n"
                             + "B. Create New Task\n"
                             + "Z. Exit to Menu\n"
                             + "Enter selection: ");
        char choice = scnr.nextLine().charAt(0);
        switch (choice) {
            case 'A':
                
                break;
            case 'B':

                break;
            case 'C':
                
                break;
            default:
                break;
        }
    }

    private static void task() {
        clearTerminal();
        System.out.print("A. View Tasks\n"
                             + "B. Create New Task\n"
                             + "Z. Exit to Menu\n"
                             + "Enter selection: ");
        char choice = scnr.nextLine().charAt(0);
        String name = null;
        switch(choice) {
            // Open Board
            case 'A':
                clearTerminal();
                
                break;
            // Create Board
            case 'B':
                clearTerminal();
                System.out.print("Enter board name: ");
                name = scnr.nextLine();

                System.out.print("[O]pen or [P]rivate: ");
                char openChar = scnr.nextLine().charAt(0);
                boolean open = false;
                if(openChar == 'O')
                    open = true;

                AppFacade.getInstance().getActiveCompany().addBoard(new Board(name, open));
                break;
            // Active Board
            case 'C':
                
            case 'Z':
                clearTerminal();
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

    private static void clearTerminal() {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }
    private static void printActive() {
        try{
            System.out.println("Active User: " + AppFacade.getInstance().getActiveUser().getEmail());
        } catch (Exception e) {
            System.out.println("Active User: NONE");
        }
        try{
            System.out.println("Active Company: " + AppFacade.getInstance().getActiveCompany().getName());
        } catch (Exception e) {
            System.out.println("Active Company: NONE");
        }
        try{
            System.out.println("Active Board: " + AppFacade.getInstance().getActiveBoard().getTitle());
        } catch (Exception e) {
            System.out.println("Active Board: NONE");
        }
        
    }
}
