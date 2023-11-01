import java.util.UUID;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author Gavin Hewitt
 * @version v1.0
 * Date: 10/31/23
 */

public class Scenario {
  private static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    run();
  }
  /**
   * Inputs don't matter, just there to make it look like it's functional. I can tell you what to input when recording if it's unclear.
   */
  private static void run() {
    System.out.println("Signing in Atticus Madden of Code Mission Possible...");
    login();
    addBoards();
    jeff();
    // prompts for input in ui to make it look funcitonal
    System.out.print("\nWhich project would you like to select?\n1. Electric Missiles\t2. Soap Free Washers\t3. Air Computers");
    int projectInt = Integer.parseInt(scan.nextLine());
    boolean cont = true;
    if(projectInt == 1) {
      System.out.println("Electric Missiles Selected.");
      selectBoard("Electric Missiles");
      createExistingInfo(); // CSO: THis appears to initalise electric missles. Moved from line 24 to 30.
    }
    else System.exit(1);
    while(cont) {
      System.out.print("\nWould you like to do?\t1. Add Task\t2. Move Task\t3. Reassign Task\t4. Create New Column\t5. Reply to a comment\t6. Write to file\t7. Exit ");
      int input = scan.nextInt();
      switch(input) {
        case 1: 
          System.out.print("What is your task's name? ");
          scan.nextLine();
          System.out.print("What is the description of your task? ");
          scan.nextLine();
          System.out.print("Who would you like to assign this task to? ");
          scan.nextLine();
          addTask();
          System.out.print("Would you like to leave a comment? (type 'n' for no, otherwise type the comment) ");
          scan.nextLine();
          addComment();
          System.out.println("Task added successfully.\n");
          break;
        case 2: 
          System.out.print("What task would you like to move?\t1. Impossible Burger\t2. Curve Metal\t3. Super Algorithm ");
          int taskNum = scan.nextInt();
          System.out.print("Which Column would you like to move it to? ");
          String moveColumn = scan.nextLine();
          if(taskNum == 1)
            moveBurger();
          else
            moveMetal(moveColumn);
          System.out.println("Task moved successfully.\n");
          break;
        case 3: 
          System.out.print("What task would you like to reassign?\t1. Impossible Burger\t2. Curve Metal\t3. Super Algorithm ");
          scan.nextLine();
          System.out.print("Who would you like to assign the task to? ");
          scan.nextLine();
          reassign();
          System.out.println("Task reassigned successfully.\n");
          break;
        case 4: 
          System.out.print("What is the name of the column you want to create? ");
          scan.nextLine();
          createAbandoned();
          System.out.println("Column created successfully.\n");
          break;
        case 5: 
          System.out.print("Which task do you want to open?\t1. Impossible Burger\t2. Curve Metal\t3. Super Algorithm ");
          scan.nextLine();
          System.out.print("What comment do you want to reply to?\tJeff-'Not cylindrical enough'\tYou-'What's a cylinder' ");
          scan.nextLine();
          reply();
          System.out.println("Reply successfully created.\n");
          break;
        case 6:
          //FIXME: still dk what to do with that
          break;
        case 7: cont = false;
          break;
        default: 
          System.out.println("Wrong value");
      }
    }
  }
  /*
    *  Your name is Atticus Madden.
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
  private static final User ATTY = LoginManager.getInstance().getUser("amadden@gmail.com", "mockingbirdFootball1");
  private static final User JEFF = LoginManager.getInstance().getUser("mynamejeff@aol.com", "ohbrotherthisguystinks");
  private static void login() {
    AppFacade.getInstance().signUp("Atticus", "Madden", "amadden@gmail.com", "mockingbirdFootball1");
  }
  private static void addBoards() {
    AppFacade.getInstance().setActiveCompany(new Company("Code Mission Possible"));
    AppFacade.getInstance().getCurrentUser().addCompany(AppFacade.getInstance().getActiveCompany());
    AppFacade.getInstance().getActiveCompany().addBoard(new Board("Electric Missiles", true));
    AppFacade.getInstance().getActiveCompany().addBoard(new Board("Soap Free Washers", true));
    AppFacade.getInstance().getActiveCompany().addBoard(new Board("Air Computers", true));
  }
  private static void jeff() {
    AppFacade.getInstance().signUp("Jeff", "Goldblum", "mynamejeff@aol.com", "ohbrotherthisguystinks");
    AppFacade.getInstance().getActiveCompany().addUser(LoginManager.getInstance().getUser("mynamejeff@aol.com", "ohbrotherthisguystinks"));
    AppFacade.getInstance().setActiveUser(ATTY);
  }
  private static void selectBoard(String name) {
    AppFacade.getInstance().setActiveBoard(name);  
  }
  private static void addTask() {
    AppFacade.getInstance().getActiveBoard().createTask("Todo", UUID.randomUUID(), "Super Algorithm", "Initialize super algorithm to detonate at warp speed", LocalDateTime.now(), 
      ATTY, JEFF, Category.SOLO_PROJECT, false, 1, (float)2.0);
  }
  private static void addComment() {
    AppFacade.getInstance().getActiveBoard().getColumn("Todo").getTask("Super Algorithm").addComment("Avoid civilians Jeff!");
  }
  private static void createExistingInfo() {
    AppFacade.getInstance().getActiveBoard().createTask("Todo", UUID.randomUUID(), "Curve Metal", "Curve the metal to make a Cylindrical Shape", LocalDateTime.now(),
      ATTY, JEFF, Category.SOLO_PROJECT, false, 2, (float)0.5);
      AppFacade.getInstance().getActiveBoard().createTask("Todo", UUID.randomUUID(), "Impossible Burger", "Make impossible burger possible", LocalDateTime.now(),
      ATTY, JEFF, Category.SOLO_PROJECT, false, 3, (float)0.1);
    AppFacade.getInstance().setActiveUser(JEFF); // comment author is active user
    AppFacade.getInstance().getActiveBoard().getColumn("Todo").getTask("Curve Metal").addComment("Not cylindrical enough");
    AppFacade.getInstance().setActiveUser(ATTY);
    AppFacade.getInstance().getActiveBoard().getColumn("Todo").getTask("Curve Metal").addComment("What's a cylindar");
  }
  private static void reply() {
    AppFacade.getInstance().getActiveBoard().getColumn("Todo").getTask("Curve Metal").getComment("Not cylindrical enough").reply("How about you do it jeff");
  }
  private static void reassign() {
    AppFacade.getInstance().getActiveBoard().getColumn("Todo").getTask("Curve Metal").setAssignee(JEFF);
  }
  private static void createAbandoned() {
    AppFacade.getInstance().getActiveBoard().createColumn("Abandoned");
  }
  private static void moveMetal(String moveColumn) {
    //FIXME: maybe ?? portia calls it "doing", but that's the same as "in progress" that we have defined already
    AppFacade.getInstance().getActiveBoard().moveTask("Todo", moveColumn, "Curve Metal");
  }
  private static void moveBurger() {
    AppFacade.getInstance().getActiveBoard().moveTask("Todo", "Abandoned", "Impossible Burger");
  }
  private static void write() {
    //TODO: is the write file finished in board?
  }
}

