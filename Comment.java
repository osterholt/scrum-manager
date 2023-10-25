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
    private ArrayList<Comment> comments;

    public Comment(String comment, User author) {
        this.id = UUID.randomUUID();
        init();
        setAuthor(author);
        editComment(author, comment);
        this.time = LocalDateTime.now();
    }
    
    public Comment(User author, String comment) {
        init();
        setAuthor(author);
        editComment(author, comment);
    }
     
    public void reply(User author, String comment) { 
        if(comment != null && !comment.isEmpty()) {
            Comment newComment = new Comment(comment, author);
            comments.add(newComment);
            } else {
                Test.print("unknown");
            }
        }
    private void init() {
        //time = new Date();
        comments = new ArrayList<Comment>();
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
    public String getComment() {
        return comment;
    }
    public void editComment(User author, String comment) {
        if(comment != null)
          this.comment = comment;
    }
    
    public void editComment(String comment) {
     if(comment != null)
       this.comment = comment;
     }
     

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
    public ArrayList<Comment> getComments() {
        return comments;
    }
}
