import java.util.ArrayList;
import java.util.Date;
/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/10/2023
 */

public class Comment {
    private String comment;
    private User author;
    private Date date;
    private ArrayList<Comment> comments;

    public Comment(User author, String comment) {
        init();
        setUser(author);
        editComment(comment);
    }

    public void reply(User author, String comment) { 
        if(comment == null)
            return;
        comments.add(new Comment(author, comment));
    }

    private void init() {
        date = new Date();
        comments = new ArrayList<Comment>();
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

    public void setAuthor(User author) {
        if(author != null) {}
            this.author = author;
        else
            this.author = new User();
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}