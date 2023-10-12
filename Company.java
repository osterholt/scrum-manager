import java.util.ArrayList;

/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class Company {
    private String name;
    private ArrayList<Board>[] boards;
    private ArrayList<User>[] users;
    private ArrayList<User>[] admins;

    public Company(String aName, User self, ArrayList<User>[] users){

    }
    public boolean addUser(User user){
        return false;
    }
    public boolean removeUser(User user){
        return false;
    }
    public boolean addBoard(Board board){
        return false;
    }
    public boolean removeBoard(Board board){
        return false;
    }
    public boolean addAdmin(User user){
        return false;
    }
    public boolean removeAdmin(User user){
        return false;
    }
    public boolean isAdmin(User user){
        return false;
    }
    public ArrayList<Task>[] searchForTask(){
        return null;
    }
    
}
