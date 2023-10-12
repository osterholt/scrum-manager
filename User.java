import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class User {
    private UUID id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<Company>[] companies;
    private String role;

    public User(String firstName, String lastName, String email, String password){

    }

    public User(UUID id, String firstName, String lastName, String email, String password){

    }

    public boolean isPassword(String password){
        return false;
    }

    public boolean addCompany(Company company){
        return false;
    }

    private boolean removeCompany(Company company){
        return false;
    }
    
}
