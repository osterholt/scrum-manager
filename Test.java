import java.util.ArrayList;
import java.util.UUID;

/**
 * Test class for ScrumManager
 * @version v1.0
 * @author Cam Osterholt & Gavin Hewitt
 */

public class Test {
    private static boolean debug = true;

    //Leaderboard Testing

    //TEST_USER = {_FirstName, _LastName, _Score}
    private static final String[][] TEST_USERS = {{"Cam", "Osterholt", "cam@gmail.com", "password", "16"}, {"Evie", "Ellis", "evie@gmail.com", "password", "12"}, {"Joe", "Mama", "joe@gmail.com", "password", "26"}, {"Bill", "Clinton", "bill@gmail.com", "password", "2"}};

    public static void main(String[] args) {
        
        // testLeaderboard();
        // testCompanyManager();
    }

    public static void print(String str) {
        if(debug) 
            System.out.println(str);
    }

    /**
     * Swaps the test mode to do test cases or not.
     * @return value of debug
     */
    public static boolean toggleDebug() {
        debug = !debug;
        return debug;
    }

    // public static void testLeaderboard() {
    //     Test.print("-----Testing Leaderboard-----\n");
    //     ArrayList<User> userList = new ArrayList<>();
    //     for(String[] userStr : TEST_USERS) {
    //         UUID id = AppFacade.getInstance().signUp(userStr[0], userStr[1], userStr[2], userStr[3]);
    //         userList.add(LoginManager.getInstance().getUser(id));
    //     }
    //     Leaderboard lb = new Leaderboard();
    //     for(int i = 0; i < userList.size(); i++) {
    //         lb.updateScore(userList.get(i), Integer.parseInt(TEST_USERS[i][4]));
    //     }
    //     lb.print();
        
    //     Test.print("-----Updating User 2-----\n");
    //     lb.updateScore(userList.get(1), 4);
    //     lb.print();
        
    //     Test.print("-----Incrementing User 2-----\n");
    //     lb.incrementScore(userList.get(1));
    //     lb.print();

    //     Test.print("-----Printing top 3-----\n");
    //     String[][] arr = lb.getTopRank(3);
    //     for(String[] val : arr) 
    //         Test.print(LoginManager.getInstance().getUser(UUID.fromString(val[0])).toString() + "\tScore: " + val[1]);

    //     Test.print("-----Ending Leaderboard Testing-----\n");
    // }
    // public static void printUsers() {
    //     LoginManager logManager = LoginManager.getInstance();
    //     Test.print(logManager.toString());
    // }
    // public static void printCompanies(CompanyManager compManager) {
    //     for(Company c : compManager.getCompanies()) {
    //         System.out.println(c);
    //     }
    // }
    // public static void testCompanyManager() {
    //     CompanyManager compManager = CompanyManager.getInstance();
    //     User wowAdmin = new User("wow", "admin", "wowie@hotmail.com", "zooweeemama");
    //     User boeJiden = new User("boe", "jiden", "mepres@usarules.gov", "iheartkamala");
    //     User missHarris = new User("kamala", "harris", "kama@usarules.gov", "ilaughatnothing");
    //     ArrayList<User> users = new ArrayList<User>();
    //     users.add(boeJiden); users.add(missHarris);
    //     Company hello = new Company("hiiii", wowAdmin, users, UUID.randomUUID());
    //     compManager.addCompany(hello);
    //     printCompanies(compManager);
    //     CompanyManager.saveCompanies();
    //     System.out.println(CompanyManager.getCompany("hiiii"));
    //     System.out.println(CompanyManager.getCompany(hello.getID()));
    // }
}
