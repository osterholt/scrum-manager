import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDateTime;

/**
 * @author Cam Osterholt & SB
 * @version v1.0
 * Date: 10/10/2023
 */
public class Comment {
    //private UUID id;
    private String comment;
    private User author;
    private LocalDateTime time;
    private ArrayList<Comment> comments;
    private AppFacade appFacade;
    
    public Comment(User author, String comment, AppFacade appFacade) {
        setAuthor(author);
        editComment(author, comment);
        this.time = LocalDateTime.now();
        this.comments = new ArrayList<Comment>();
        this.appFacade = appFacade;
    }
    
    public void reply(User author, String comment) { 
        if(comment != null) {
            Comment reply = new Comment(author, comment, this.appFacade);
            comments.add(reply);
        }
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
          this.time = LocalDateTime.now();
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
    
    public ArrayList<Comment> getComments() {
        return comments;
    }
}
