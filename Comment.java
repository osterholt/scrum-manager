import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/10/2023
 */

public class Comment {
    private UUID id;
    private String comment;
    private User author;
    private Date date;
    private ArrayList<Comment> comments;

    public Comment(User author, String comment) {
        init(author, comment);
    }

    public void reply(User author, String comment) { 
        if(comment == null)
            return;
        comments.add(new Comment(author, comment));
    }

    private void init(User author, String comment) {
        date = new Date();
        comments = new ArrayList<Comment>();
        setAuthor(author);
        editComment(comment);
    }

    public UUID getID() {
        return this.id;
    }
    
    private boolean setID(UUID id) {
        if(id == null)
            return false;
        this.id = id;
        return true;
    }

    public String getComment() {
        return comment;
    }

    public void editComment(String comment) {
        if(comment == null)
            return;
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

    public Date getDate() {
        return date;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public boolean deleteComment(UUID id) {
        for(Comment comment : this.comments) {
            if(comment.getID().equals(id)) {
                comments.remove(comment);
                return true;
            }
            if(comment.deleteComment(id)) 
                return true;
        }
        return false;
    }
}