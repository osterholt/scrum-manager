import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;

/**
 * @author Cam Osterholt & SB
 * @version v1.0
 * Date: 10/10/2023
 */
public class Comment {
    private UUID id;
    private String comment;
    private User author;
    private LocalDateTime time;
    //to be flexible with board and task classes
    private Object object;
    //private ArrayList<Comment> comments;

    public Comment(String comment, User author, Object object) {
        this.id = UUID.randomUUID();
        this.comment = comment;
        this.author = author;
        this.object = object;
        this.time = LocalDateTime.now();
        /*
        CAM-
        init();
        setAuthor(author);
        editComment(author, comment);
        */
    }
    /*
    CAM-
    public Comment(User author, String comment) {
        init();
        setAuthor(author);
        editComment(author, comment);
    }
    */
    //sb flexible . instance of to either associate  with baord or task
    //addComment is not added to Board class. add or no? 
    public void reply(User author, String comment) { 
        if(comment != null && !comment.isEmpty()) {
            if(object instanceof Board) {
              Board board = (Board) object;
              board.addComment(new Comment(comment, author, board));
            } else if (object instanceof Task) {
                Task task = (Task) object;
                task.addComment(new Comment(comment, author, task));
            } else {
                Test.print("unknown");
            }
        }
    }
    /*
    CAM-
    private void init() {
        date = new Date();
        comments = new ArrayList<Comment>();
    }
    */
    public Object getObject() {
        return object;
    }
    public UUID getId() {
        return id;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public void setObject(Object object) {
        this.object= object;
    }
    public String getComment() {
        return comment;
    }
    public void editComment(User author, String comment) {
        if(comment == null)
          this.comment = comment;
    }
    /*CAM-
     * public void editComment(String comment) {
     * if(comment == null)
     *   return;
     * this.comment = comment;
     * }
     */

    public User getAuthor() {
        return author;
    }

    public boolean setAuthor(User author) {
        if(author != null) {
            this.author = author;
            return true;
        }
        else {
            System.out.println("Invalid Author.");
            return false;
        }
    }
    /*
    public Date getDate() {
        return date;
    }
    */
    /*
    public ArrayList<Comment> getComments() {
        return comment;
    }
    */
}
