import java.util.ArrayList;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class Column {
    private String title;
    private String description;
    private ArrayList<Task>[] tasks;

    public Column(String title, String description){
        
    }
    public boolean addDescription(String description){
        return false;
    }
    public boolean addTask(Task task){
        return false;
    }
    public boolean editTitle(String title){
        return false;
    }
    public boolean taskReorder(int index, Task task){
        return false;
    }

    /**
     * Returns title of the column.
     * @return String representing the title.
     * @autor Cam Osterholt
     */
    public String getTitle() {
        return title;
    }
    
}
