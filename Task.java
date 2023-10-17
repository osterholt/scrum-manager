/**
 * @author Gavin Hewitt
 * @version v1.0
 * Date: 10/12/23
 */

import java.util.ArrayList;
import java.util.UUID;

public class Task {
    private UUID id;
    private String name;
    private String description;
    private User author;
    private User assignee;
    private Category category;
    private boolean resolved;
    private int priority;
    private float timeRequired;
    private ArrayList<Comment> comments;
    private History history;

    public Task(String aName) {

    }

    public Task(UUID id, String name, String description, User author, User assignee, Category category, boolean resolved, float timeRequired) {
        init(id, name, description, author, assignee, category, resolved, timeRequired);
    }

    private void init(UUID id, String name, String description, User author, User assignee, Category category, boolean resolved, float timeRequired) {



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

    public UUID getID() {
        return this.id;
    }
}
