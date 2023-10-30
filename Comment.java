import java.util.ArrayList;
//import java.util.UUID;
import java.time.LocalDateTime;

/**
 * @author Cam Osterholt & SB
 * @version v1.0
 * Date: 10/10/2023
 */
public class Comment {
    private String comment;
    private User author;
    private LocalDateTime time;
    private ArrayList<Comment> comments;
    /**
     * @param author The author of the comment
     * @param comment The content of the comments
     */
    public Comment(User author, String comment) {
        setAuthor(author);
        editComment(author, comment);
        this.time = LocalDateTime.now();
        this.comments = new ArrayList<Comment>();
    }
    /**
     * Add reply to comment with an Author in mind and reply text.
     * @param author of the reply
     * @param comment: the author text content
     */
    public void reply(User author, String comment) { 
        if(comment != null) {
            Comment reply = new Comment(author, comment);
            comments.add(reply);
        }
    }
    /**
     * Get the time/date when comment was created
     * @return show the time/date of the comment
     */
    public LocalDateTime getTime() {
        return time;
    }
    /**
     * Set the time/date for the comment
     * @param time time for the content of comment
     */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    /**
     * Get the txt content of the comment
     * @return the text content of the comment
     */
    public String getComment() {
        return comment;
    }
    /**
     * edit the comment and update the time/date
     * @param author author making the edit
     * @param comment update comment content
     */
    public void editComment(User author, String comment) {
        if(comment != null)
          this.comment = comment;
          this.time = LocalDateTime.now();
    }
    /**
     * Get the author comment
     * @return author of the comment
     */
    public User getAuthor() {
        return author;
    }
    /**
     * Set Author's comment
     * @param author new auhtor's comment
     * @return true if the author is set 
     */
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
    /**
     * Get list of comments replying to this comment.
     *
     * @return list of reply comments.
     */
    public ArrayList<Comment> getComments() {
        return comments;
    }
}
