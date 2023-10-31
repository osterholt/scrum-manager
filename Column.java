import java.util.ArrayList;
import java.util.UUID;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class Column {
    private String title;
    private String description;
    private ArrayList<Task> tasks;

    public Column(String title, String description){
        init(title, description);
    }

    private void init(String title, String description) {
        setTitle(title);
        setDescription(description);
        tasks = new ArrayList<Task>();
    }

    public boolean addDescription(String description){
        return false;
    }
    public boolean addTask(UUID id, String name, String description, User author, User assignee, Category category, boolean resolved, int priority, float timeRequired){
        Task newTask = new Task(id, name, description, author, assignee, category, resolved, priority, timeRequired);
        for(Task task : tasks) {
            if(task.equals(newTask))
                return false;
        }
        tasks.add(newTask);
        return true;
    }
    public boolean addTask(Task task) {
        for(Task currTask : tasks) {
            if(currTask.equals(task))
                return false;
        }
        tasks.add(task);
        return true;
    }
    public boolean editTitle(String title){
        return false;
    }
    public boolean taskReorder(int index, Task task){
        //sb
        if(index >= 0 && index < tasks.size()) {
            tasks.add(index, task);
            return true;
        }
        return false;
    }

    public Task getTask(UUID id) {
        for(Task task : tasks) {
            if(task.getID().equals(id))
                return task;
        }
        return null;
    }
    public Task getTask(String name) {
        for(Task task : tasks) {
            if(task.getName().equals(name))
                return task;
        }
        return null;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Returns title of the column.
     * @return String representing the title.
     * @autor Cam Osterholt
     */
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
    
}
