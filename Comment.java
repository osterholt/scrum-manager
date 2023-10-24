import java.util.ArrayList;
import java.util.Date;
//java.util.List;
/**
 * @author Cam Osterholt
 * @version v1.0
 * Date: 10/10/2023
 */
//sb - line 13 use List<comment> as the type for the comment list. this will make it more flexible with implementation w. changing interface
public class Comment {
    private String comment;
    private User author;
    private Date date;
    private ArrayList<Comment> comments;

    public Comment(User author, String comment) {
        init();
        setAuthor(author);
        editComment(comment);
    }

    public void reply(User author, String comment) { 
        if(comment == null || comment.isEmpty())
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
        if(comment == null || comment.isEmpty())
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
}
