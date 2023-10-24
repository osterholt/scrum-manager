/**
 * @author Gavin Hewitt
 * @version v1.0
 * Date: 10/12/23
 */

import java.util.ArrayList;
import java.util.UUID;

public class Task {
    private UUID id;
    private UUID authorid;
    private UUID assigneeid;
    private String name;
    private String description;
    private String date;
    private User author;
    private User assignee;
    private Category category;
    private boolean resolved;
    private int priority;
    private float timeRequired;
    private ArrayList<Comment> comments;
    private History history;

    public Task(String name, User author) {
        //added sb
        //genrate a unique ID for task
        this.id = UUID.randomUUID(); 
        this.name = name;
        this.author = author;
        this.comments = new ArrayList<>();

    }

    public Task(UUID id, String name, String description, User author, User assignee, Category category, boolean resolved, int priority, float timeRequired) {
        init(id, name, description, date, author, assignee, category, resolved, priority, timeRequired);
    }

    private void init(UUID id, String name, String description, String date, User author, User assignee, Category category, boolean resolved, int priority, float timeRequired) {
        setUUID(id);
    }
    private boolean setUUID(UUID id) {
        if(id == null)
            id = UUID.randomUUID();
        this.id = id;
        return true;
    }
    

    public boolean changeCategory() {
        return false;
    }

    public boolean resolve() {
        return false;
    }

    public boolean changePriority(int priority) {
        return false;
    }

    public boolean addComment(Comment comment) {
        return false;
    }

    public boolean deleteComment(Comment comment) {
        return false;
    }

    public UUID getAuthorID() {
        return this.authorid;
    }

    public UUID getAssignedID() {
        return this.assigneeid;
    }

    public UUID getID() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public User getAssignee() {
        return assignee;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isResolved() {
        return resolved;
    }

    public int getPriority() {
        return priority;
    }

    public float getTimeRequired() {
        return timeRequired;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public History getHistory() {
        return history;
    }

    public String getDate() {
        return date;
    }
}
