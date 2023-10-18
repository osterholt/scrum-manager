import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author Evelyn Ellis & Cam Osterholt
 * @version v1.0
 * Date: 10/12/2023
 */
public class Leaderboard {
     private ArrayList<User>[] leaderboard;
     private HashMap<User, Integer> scores;

     public Leaderboard() {
          scores = new HashMap<User, Integer>();
     }


     // FIXME: WHAT THE HELL HOW DO YOU SORT A HASHMAP?? 
     private boolean sortList(){
          HashMap<User, Integer> temp = new HashMap<User, Integer>();
          

          return false;
     }
     public HashMap<User, Integer> getTop10(){
          return null;
     }
     public int getRank(UUID id) {
          User ret = null;
          for(User user : scores.keySet()) {
               if(user.getId().equals(id))
                    ret = user;
          }
          return getRank(ret);
     }
     public int getRank(User user){
          return scores.get(user);
     }
     public int getRank() {
          return scores.get(AppFacade.getActiveUser());
     }

     /**
      * Increments User score for one completed task.
     * @param user User to update.
     * @return User's current score.
     * @author Cam Osterholt
     */
     public int updateScore(User user) {
          return updateScore(user, 1);
     }
     /**
      * Increments User score for one completed task.
     * @param user User to update.
     * @return User's current score.
     * @author Cam Osterholt
     */
     public int updateScore(User user, int increment){
          if(!inLeaderboard(user))
               scores.put(user, increment);
          else
               scores.put(user, scores.get(user) + increment);
          sortList();
          return scores.get(user);
     }

     public String toString() {
          String str = "";
          for(User user : scores.keySet()) {
               str += user.getFirstName() + " " + user.getLastName() + "\tScore: " + scores.get(user) + "\n";
          }
          return str;
     }
     public void print() {
          System.out.print(toString());
     }


     /**
      * Determines if a user is in the leaderboard
      * @param user User to check
      * @return if user is in leaderboard.
      */
     private boolean inLeaderboard(User user) {
          for(User key : scores.keySet()) {
               if(key.equals(user))
                    return true;
          }
          return false;
     }
    
}
