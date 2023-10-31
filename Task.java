/**
 * @author Gavin Hewitt
 * @version v1.0
 * Date: 10/12/23
 */

import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;

public class Task {
    private UUID id;
    private String name;
    private String description;
    private LocalDateTime time;
    private User author;
    private User assignee;
    private Category category;
    private boolean resolved;
    private int priority;
    private float timeRequired;
    private ArrayList<Comment> comments;
    private ArrayList<History> history;

    private final int DEF_PRIORITY = 3;
  
    public Task(String name, User author) {
        //genrate a unique ID for task
        this.id = UUID.randomUUID(); 
        this.name = name;
        this.author = author;
        this.comments = new ArrayList<>();

    }

    public Task(UUID id, String name, String description, User author, User assignee, Category category, boolean resolved, int priority, float timeRequired) {
        init(id, name, description, time, author, assignee, category, resolved, priority, timeRequired);
    }

    public Task(String aName) {
        init(null, aName, null, null, null, null, null, false, DEF_PRIORITY, 0);
    }

    /**
     * Creates Task from JSON's parameters
     * @param id
     * @param name
     * @param description
     * @param date
     * @param author
     * @param assignee
     * @param category
     * @param resolved
     * @param priority
     * @param timeRequired
     */
    public Task(UUID id, String name, String description, String time, User author, User assignee, Category category, boolean resolved, int priority, float timeRequired) {
        init(id, name, description, time, author, assignee, category, resolved, priority, timeRequired);
    }

    private void init(UUID id, String name, String description, String time, User author, User assignee, Category category, boolean resolved, int priority, float timeRequired) {
        setUUID(id);
        setName(name);
        setDescription(description);
        setTime(time);
        setAuthor(author);
        setAssignee(assignee);
        setCategory(category);
        setResolve(resolved);
        setPriority(priority);
        setTimeRequired(timeRequired);
        this.comments = new ArrayList<>();
        this.history = new ArrayList<>();

    }
    private boolean setUUID(UUID id) {
        if(id == null)
            id = UUID.randomUUID();
        this.id = id;
        return true;
    }
    private void setAssignee(User assignee) {
        this.assignee = assignee;
    }
    private void setAuthor(User author) {
        this.author = author;
    }
    private void setCategory(Category category) {
        this.category = category;
    }
    

    public boolean changeCategory(Category category) {
        if(category == null)
            return false;
        this.category = category;
        return true;
    }

    public boolean resolve() {
        this.resolved = true;
        return this.resolved;
    }
    private boolean setResolve(boolean resolved) {
        this.resolved = resolved;
        return true;
    }

    public int getPriority() {
        return this.priority;
    }
    public boolean addComment(Comment comment) {
        comments.add(comment);
        return false;
    }

    public boolean setPriority(int priority) {
        if(priority > 0 && priority < 4)
            this.priority = priority;
        else
            this.priority = DEF_PRIORITY;
        return true;
    }

    public boolean addComment(String description) {
        return this.comments.add(new Comment(AppFacade.getActiveUser(), description));
    }

    public boolean deleteComment(UUID id) {
        for(Comment comment : comments) {
            if(comment.getID().equals(id)) {
                comments.remove(comment);
                return true;
            }
            if(comment.deleteComment(id))
                return true;
        }
        return false;
    }

    public UUID getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public boolean setDescription(String description) {
        if(description == null)
            return false;
        this.description = description;
        return true;
    }

    public User getAuthor() {
        return author;
    }
    private boolean setAuthor(User author) {
        if(author == null)
            author = AppFacade.getActiveUser();
        this.author = author;
        return true;
    }

    public User getAssignee() {
        return assignee;
    }
    public boolean setAssignee(User assignee) {
        // Allow null to have no assignee.
        this.assignee = assignee;
        return true;
    }

    public Category getCategory() {
        return category;
    }
    public boolean setCategory(Category category) {
        if(category == null)
            return false;
        this.category = category;
        return true;
    }

    public boolean isResolved() {
        return resolved;
    }

    public float getTimeRequired() {
        return timeRequired;
    }

    public boolean setTimeRequired(float timeRequired) {
        if(timeRequired % 0.5 != 0)
            return false;    
        this.timeRequired = timeRequired;
        return true;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<History> getHistory() {
        return history;
    }

    public String timeDate() {
        return this.time.toString();
    }
    
    private boolean setTime(String dateStr) {
        if(dateStr == null)
            this.time = LocalDateTime.now();
        else    
            this.time = LocalDateTime.parse(dateStr);
        return true;
    }

    // ------------

    private boolean setName(String name) { 
        if(name == null)
            return false;    
        this.name = name;
        return true;
    }
    public void setHistory(ArrayList<History> history) {
        this.history = history;
    }

    public String getDate() {
        return date;
    }
}
