import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/10/2023
 */

public class AppFacade {
    private User activeUser;
    private Company activeCompany;
    private Board activeBoard;
    private static AppFacade appFacade;

    private AppFacade() {
        activeUser = null;
        activeCompany = null;
        activeBoard = null;
    }

    public static AppFacade getInstance() {
        if(appFacade == null)
            appFacade = new AppFacade();
        return appFacade;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User active){
        activeUser = active;
    }

    public Board getActiveBoard() {
        return activeBoard;
    }

    public boolean login(String username, String password) {
        activeUser = LoginManager.getInstance().getUser(username, password);
        if(activeUser == null){
            return false;
        }
        return true;
    }

    public User getCurrentUser(){
        return activeUser;
    }

    public UUID signUp(String firstName, String lastName, String email, String password) {
        User user = new User(firstName, lastName, email, password);
        LoginManager.getInstance().addUser(user);
        setActiveUser(user);
        return user.getId();
    }

    public User getUser(UUID id) {
        return LoginManager.getInstance().getUser(id);
    }

    public void logOut() {
        LoginManager.getInstance().saveUsers();
        LoginManager.getInstance().saveTasks();
        LoginManager.getInstance().saveCompanies();
    }

    public Company getActiveCompany() {
        return activeCompany;
    }

    public boolean setActiveCompany(String name) {
        return null != (activeCompany = CompanyManager.getCompany(name));
    }
    public boolean setActiveCompany(Company company) {
        return null != (activeCompany = company);
    }

    public boolean setActiveBoard(String name) {
        if(name == null)
            return false;
        return null != (activeBoard = AppFacade.getInstance().getActiveCompany().getBoard(name));
    }

}
