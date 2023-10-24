import java.util.Date;
import java.time.LocalDate;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class History {

    private Date date;
    private User user;
    private String change;
    /* 
     * 
     * date, user, change --> task has ARRAY LIST OF INSTANCES
     */

    public History(Date date, User user, String change){
        this.date = date;
        this.user = user;
        this.change = change;

    }
    public Date getDate(){
        return date;

    private History(){
        entries = new ArrayList<Update>();
    }
    public static History getInstance(){
        if(history == null)
            history = new History();
        return history;

    }
    public User getUser(){
        return user;
    }
    public String getChange(){
        return change;
    }
    
    public String toString(){
        return date.toString() + " " + user.getFirstName() + " " + user.getLastName() + " " + change;

    public boolean updateHistory(Update change){
        return false;
    }
    public Update removeChange(int id){
        return null;
    }

    // test
  /*   public static void main(String[] args) {
        User myUser = new User("Evie", "Ellis", "evie.ellis11@gmail.com", "B3llyR@$h");
        Date myDate = new Date(1000000000);
        History myHistory = new History(myDate, myUser, "popped and pushed their shit");
        System.out.println(myHistory.toString());
    
    }
    */
}

