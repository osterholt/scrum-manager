import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.plaf.ColorUIResource;
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
        initScenario();
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
                case 'E':
                    task();
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

    private static void initScenario() {
        AppFacade.getInstance().signUp("Jeff", "Goldblum", "jgoldblum@email.sc.edu", "password");
        AppFacade.getInstance().signUp("Atticus", "Finch", "afinch@email.sc.edu", "password");
        AppFacade.getInstance().signUp("Atticus", "Madden", "amadden@email.sc.edu", "password");

        CompanyManager.getInstance().addCompany(new Company("Code Mission Possible"));

        AppFacade.getInstance().getActiveCompany().addBoard(new Board("Electric Missiles", false));
        AppFacade.getInstance().getActiveCompany().addBoard(new Board("Soap Free Washers", false));
        AppFacade.getInstance().getActiveCompany().addBoard(new Board("Air Computers", false));
        
        System.out.println("Now opening last used Board: Electric Missiles");
        AppFacade.getInstance().setActiveBoard("Electric Missiles");

        Task curveMetal = new Task("Curve the metal to make a cylindrical shape");
        AppFacade.getInstance().getActiveBoard().getColumn(0).addTask(curveMetal); // Create "Curve the metal to make the cylindrical shape"

        Task impossibleBurger = new Task("Make impossible burger possible");
        AppFacade.getInstance().getActiveBoard().getColumn(0).addTask(impossibleBurger); // Create "Curve the metal to make the cylindrical shape"
        
        AppFacade.getInstance().login("jgoldblum@email.sc.edu", "password");
        curveMetal.addComment("Not cylindrical enough");

        AppFacade.getInstance().login("afinch@email.sc.edu", "password");
        curveMetal.addComment("What's a cylinder");

        AppFacade.getInstance().login("amadden@email.sc.edu", "password");
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
                             + "D. Create New Column\n"
                             + "E. Export Board to File\n"
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
            case 'D':
                clearTerminal();
                System.out.print("Enter Column Name: ");
                name = scnr.nextLine();
                AppFacade.getInstance().getActiveBoard().addColumn(new Column(name));
                break;
            case 'E':
                clearTerminal();
                System.out.print("Enter File Name: ");
                name = scnr.nextLine();
                AppFacade.getInstance().getActiveBoard().writeToTextFile(name + ".txt");
                break;
            case 'Z':
                clearTerminal();
                return;
        }
    }

    //FIXME: Do we need??
    private static void column() {
        clearTerminal();
        System.out.print("A. View Column\n"
                             + "B. Create New Column\n"
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
                             + "C. Comment\n"
                             + "D. View Comments\n"
                             + "E. Move Task\n"
                             + "F. Assign Task\n"
                             + "Z. Exit to Menu\n"
                             + "Enter selection: ");
        char choice = scnr.nextLine().charAt(0);
        String name = null;
        int index = 0;
        String text = "";
        Column col = null;
        switch(choice) {
            // View Tasks
            case 'A':
                clearTerminal();
                System.out.println(AppFacade.getInstance().getActiveBoard().toString());
                break;
            // Create Task
            case 'B':
                clearTerminal();
                printColumns();
                index = 0;
                System.out.print("Enter column choice: ");
                index = Integer.parseInt(scnr.nextLine());

                System.out.print("Enter Task Name: ");
                text = scnr.nextLine();

                AppFacade.getInstance().getActiveBoard().getColumn(index - 1).addTask(text);
                break;
            // Comment
            case 'C':
                clearTerminal();
                printColumns();
                index = 0;
                System.out.print("Enter column choice: ");
                index = Integer.parseInt(scnr.nextLine());
                col = AppFacade.getInstance().getActiveBoard().getColumn(index - 1);

                System.out.print("Enter Task Name: ");
                text = scnr.nextLine();
                Task task = col.getTask(text);

                System.out.print("Enter Comment: ");
                text = scnr.nextLine();
                task.addComment(text);
                break;
            case 'D':
                clearTerminal();
                System.out.print("Enter Task Name: ");
                name = scnr.nextLine();
                commentViewer(name);
                break;
            case 'E':
                clearTerminal();
                Board ab = AppFacade.getInstance().getActiveBoard();
                printColumns();
                index = 0;
                System.out.print("Enter original column: ");
                index = Integer.parseInt(scnr.nextLine());

                System.out.print("Enter Task Name: ");
                name = scnr.nextLine();

                System.out.print("Enter new column choice: ");
                int index2 = Integer.parseInt(scnr.nextLine());
                ab.moveTask(ab.getColumn(index - 1).getTitle(), ab.getColumn(index2 - 1).getTitle(), name);

                System.out.println("Task is now in column: " + index2);

                break;
            case 'F':
                clearTerminal();
                System.out.print("Enter Task Name: ");
                name = scnr.nextLine();
                task = AppFacade.getInstance().getActiveBoard().getTask(name);

                System.out.print("Enter Assignee's Email: ");
                name = scnr.nextLine();

                task.setAssignee(LoginManager.getInstance().getUser(name, "password"));

                break;
            case 'Z':
                clearTerminal();
                return;
        }
    }


    private static void printColumns() {
        ArrayList<Column> columns = AppFacade.getInstance().getActiveBoard().getColumns();
        for(int i = 0; i < columns.size(); i++) {
            System.out.println(i + 1 + ". " + columns.get(i).getTitle());
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
    private static void commentViewer(String taskName) {
        Task task = AppFacade.getInstance().getActiveBoard().getTask(taskName);
        if(task == null) {
            System.out.println("Invalid Task Name");
            return;
        }
        ArrayList<Comment> comments = task.getComments();
        char choice = ' ';
        int index = 0;
        if(comments.size() == 0)
            System.out.println("No Commments for " + task.getName());

        while(choice != 'E') {
            if(index < comments.size()) {
                System.out.println(comments.get(index));
                System.out.print("[N]ext, [R]eply, [E]xit to Menu: ");
                choice = scnr.nextLine().charAt(0);
                if(choice == 'R') {
                    System.out.print("Enter comment: ");
                    String com = scnr.nextLine();
                    comments.get(0).reply(com);
                }
                if(choice == 'N')
                    index++;
                else if(choice == 'E')
                    return;
                clearTerminal();
            }
            else 
                return;
        }
    }
}
