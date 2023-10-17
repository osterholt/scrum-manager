import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Evelyn Ellis & Cam Osterholt
 * @version v1.0
 * Date: 10/10/2023
 */
public class User {
    private UUID id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private ArrayList<Company> companies;
    private String role;

    public User(String firstName, String lastName, String email, String password) {  
        UUID tempid = UUID.randomUUID();
        init(tempid, firstName, lastName, email, password);
    }
    public User(UUID id, String firstName, String lastName, String email, String password) {
        init(id, firstName, lastName, email, password);
    }
    private void init(UUID id, String firstName, String lastName, String email, String password) {
        this.companies = new ArrayList<Company>();
        setUUID(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }
    
    public boolean isPassword(String password) {
        return this.password.equals(password);
    }
    public boolean addCompany(Company company) {
        if(company == null)
            return false;
        companies.add(company); //TODO: Fix when add Company class
        return true;
    }
    private boolean removeCompany(Company company) {
        return true; //TODO: Implement
    }

    public UUID getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        if(firstName == null)
            return;
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        if(lastName == null)
            return;
        this.lastName = lastName;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        if(role == null)
            return;
        this.role = role;
    }

    private boolean setUUID(UUID id) {
        if(id == null)
            id = UUID.randomUUID();
        this.id = id;
        return true;
    }
    private boolean setEmail(String email) {
        if(email == null) {
            System.out.println("Invalid Email. Login Failed.");
            return false;
        }
        this.email = email;
        return true;
    }
    public String getPassword() {
        return password;
    }
    private boolean setPassword(String password) {
       if(password == null) {
            System.out.println("Invalid Password. Login Failed.");
            return false;
        }
        this.password = password;
        return true; 
    }
}