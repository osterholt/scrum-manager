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
        
        testLeaderboard();
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

    public static void testLeaderboard() {
        Leaderboard lb = new Leaderboard();
        for(String[] userStr : TEST_USERS) {
            lb.updateScore(new User(userStr[0], userStr[1], userStr[2], userStr[3]), Integer.parseInt(userStr[4]));
        }
        lb.print();
        //TODO: In progress by Cam
    }
}
