import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class Company {
    private UUID id;
    private String name;
    private ArrayList<Board>[] boards;
    private ArrayList<User>[] users;
    private ArrayList<User>[] admins;

    public Company(String aName, User self, ArrayList<User>[] users, UUID id){
        setUUID(id);
        this.name = aName;
    }

    public String getName() {
        return name;
    }
    private void setUUID(UUID id) {
        if(id == null)
            id = UUID.randomUUID();
        this.id = id;
    }
    public UUID getID() {
        return id;
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
    public boolean equals(Company company) {
        return true;
    }
    /**
     * Checks that all data members are properly initialized
     * @return boolean
     */
    public boolean isValid() {
        return true;
    }
}
