import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class Leaderboard {
    private ArrayList<User>[] leaderboard;
    private HashMap<User, Integer> scores;

   private boolean sortList(){
        return false;
   }
   public HashMap<User, Integer> getTop10(){
        return null;
   }
   public int getRank(User user){
        return 0;
   }

     /**
      * Increments User score for one completed task.
     * @param user User to update.
     * @return User's current score.
     */
     public int updateScore(User user) {
          return updateScore(user, 1);
     }
     /**
      * Increments User score for one completed task.
     * @param user User to update.
     * @return User's current score.
     */
     public int updateScore(User user, int increment){
          return 0;
     }
    
}
