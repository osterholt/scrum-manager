import java.util.ArrayList;
/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/15/2023
 */

public class Board {
    private String title;
    private String description;
    private ArrayList<Column> columns;
    private boolean open; //If can be accessed by anyone
    private User scrumMaster;
    private User productOwner;
    private ArrayList<User> developers;
    private AppFacade af;

    private final String[] DEF_COLUMNS = {"Todo", "In Progress", "Done"};

    public Board(String title, boolean open) {
        init(title, null, open);
    }
    public Board(String title, String description, boolean open) {
        init(title, description, open);
    }

    private void init(String title, String description, boolean closed) {
        setDefaultColumns();
        developers = new ArrayList<User>();

        //TODO: Getters and setters.
    }

    /**
     * Sets the default columns. Current implemtation has Todo, In Progress, and Done. 
     */
    private void setDefaultColumns() {
        columns = new ArrayList<Column>();
        for(String str : DEF_COLUMNS) {
            columns.add(new Column(str, null));
        }
    }

    public boolean completeTask(Task task) {

        return true; //TODO: fix
    }

    public ArrayList<Task> getTasks() {

        return null; //TODO: fix
    }

    public ArrayList<Task> getBacklog() {

        return null; //TODO: fix
    }

    public boolean deleteTask(Task task) {

        return true; //TODO: fix
    }

    public Leaderboard getLeaderboard() {

        return null; //TODO: fix
    }

    public boolean createTask() {

        return true; //TODO: fix
    }

    public boolean createColumn() {

        return true; //TODO: fix
    }

    //FIXME: Do we want 
    private boolean isDev(User user) {
        for(User dev : this.developers) {
            if(user.equals(dev))
                return true;
        }
        return false;
    }
    private boolean canEdit() {
        if(this.open)
            return true;
        if(isDev(AppFacade.getActiveUser()))
            return true;
        return false;
    }

    //---Getters and Setters---

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isOpen() {
        return open;
    }
    public void setOpen(boolean open) {
        this.open = open;
    }
}
