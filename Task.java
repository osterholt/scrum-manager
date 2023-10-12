/**
 * @author Gavin Hewitt
 * @version v1.0
 * Date: 10/12/23
 */

import java.util.ArrayList;

public class Task {
  private String name;
  private String description;
  private User author;
  private User assignee;
  private Category category;
  private boolean resolved;
  private int priority;
  private float timeRequired;
  private ArrayList<Comment> comments;

  public Task(String aName) {

  }

  public boolean changeCategory() {

  }

  public boolean resolve() {

  }

  public boolean changePriority(int priority) {

  }

  public boolean addComment(Comment comment) {

  }

  public boolean deleteComment(Comment comment) {
    
  }
}
