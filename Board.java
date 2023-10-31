import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;
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
    private Leaderboard leaderboard;

    private final String[] DEF_COLUMNS = {"Todo", "In Progress", "Done"};

    public Board(String title, boolean open) {
        init(title, null, open);
    }
    public Board(String title, String description, boolean open) {
        init(title, description, open);
    }

    private void init(String title, String description, boolean open) {
        setDefaultColumns();
        this.developers = new ArrayList<User>();
        this.developers.add(AppFacade.getInstance().getActiveUser());
        leaderboard = new Leaderboard();
        
        setTitle(title);
        setDescription(description);
        setPermissions(open);
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

    public boolean completeTask(UUID id) {
        Task task = getTask(id);
        if(task != null) {
            this.leaderboard.incrementScore(AppFacade.getInstance().getActiveUser());
            return task.resolve();
        }
        return false;
    }

    public boolean deleteTask(UUID id, String name) {
        return getTask(id, name) != null;
    }

    public Leaderboard getLeaderboard() {
        if(this.open || canEdit())
            return this.leaderboard;
        return null;
    }

    public boolean createTask(String column, UUID id, String name, String description, LocalDateTime time, User author, User assignee, Category category, boolean resolved, int priority, float timeRequired) {
        Column temp = getColumn(column);
        if(temp != null) 
            return temp.addTask(id, name, description, time, author, assignee, category, resolved, priority, timeRequired);
        return false;
    }
    public boolean addColumn(Column column) {
        if(column != null && !columns.contains(column)) {
            columns.add(column);
            return true;
        }
        return false;
    }

    public boolean createColumn(String title) {
        return createColumn(title, null);
    }

    public boolean createColumn(String title, String description) {
        if(canCreateColumn(title)) {
            columns.add(columns.size() - 2, new Column(title, description));
            return true;
        }
        else
            return false;
    }

    private boolean isDev() {
        for(User dev : this.developers) {
            if(AppFacade.getInstance().getActiveUser().equals(dev))
                return true;
        }
        return false;
    }
    private boolean canEdit() {
        if(this.open)
            return true;
        if(isDev())
            return true;
        return false;
    }

    public Column getColumn(String title) {
        for(Column column : columns) {
            if(title.equals(column.getTitle()))
                return column;
        }
        Test.print("Column Not Found.");
        return null;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    /**
     * Decides you can make a column by looping thru to decide if the title has already been picked.
     * @return boolean if you can create.
     */
    private boolean canCreateColumn(String title) {
        return getColumn(title) == null;
    }

    private Task getTask(UUID id) {
        return getTask(id, null);
    }

    private Task getTask(UUID id, String name) {
        if(id != null) {
            for(Column col : columns) {
                Task temp = col.getTask(id);
                if(temp != null)
                    return temp;
            }
        }
        else {
            for(Column col : columns) {
                Task temp = col.getTask(name);
                if(temp != null)
                    return temp;
            }
        }
        return null;
    }

    //---Getters and Setters---

    public String getTitle() {
        if(this.open || canEdit())
            return title;
        else {
            Test.print("Invalid User Permissions.");
            return null;
        }
    }
    public boolean setTitle(String title) {
        if(canEdit()) {
            this.title = title;
            return true;
        }
        else {
            Test.print("Invalid User Permissions.");
            return false;
        }
    }
    public String getDescription() {
        if(this.open || canEdit())
            return this.description;
        else {
            Test.print("Invalid User Permissions.");
            return null;
        }
    }
    public void setDescription(String description) {
        if(canEdit())
            this.description = description;
        else    
            Test.print("Invalid User Permissions.");
    }
    public boolean getPermissions() {
        return open;
    }
    public void setPermissions(boolean open) {
        if(canEdit())
            this.open = open;
        else
            Test.print("Invalid User Permissions.");
    }
    public User getScrumMaster() {
        if(this.open || canEdit())
            return this.scrumMaster;
        else {
            Test.print("Invalid User Permissions.");
            return null;
        }
    }
    public void setScrumMaster(User scrumMaster) {
        if(canEdit() && scrumMaster != null)
            this.scrumMaster = scrumMaster;
        else
            Test.print("Invalid Input.");
            
    }   
    public User getProductOwner() {
        if(this.open || canEdit())
            return this.productOwner;
        else {
            Test.print("Invalid User Permissions.");
            return null;
        }
    }
    public void setProductOwner(User productOwner) {
        if(canEdit() && productOwner != null)
            this.productOwner = productOwner;
        else
            Test.print("Invalid Input.");
    }
    public ArrayList<User> getDevelopers() {
        return developers;
    }

    public String toString() {
        //TODO: Complete
        return null;
    }
}
