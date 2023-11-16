import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 11/06/2023
 */
public class CommentTest {

    @Test
    public void testCommentCreation() {
        // Create a comment
        Comment comment = new Comment("This is a test comment.");

        // Test if comment creation and initializations are accurate
        assertNotNull(comment.getID());
        assertEquals("This is a test comment.", comment.getComment());
        assertNotNull(comment.getTime());
        assertEquals(comment.getAuthor(), AppFacade.getInstance().getActiveUser());
    }

    @Test
    public void testReplyToComment() {
        Comment mainComment = new Comment("Main comment");
        mainComment.reply("Reply to the main comment.");

        // Check if the main comment has a reply
        assertEquals(1, mainComment.getComments().size());
        assertEquals("Reply to the main comment.", mainComment.getComments().get(0).getComment());
    }

    @Test
    public void testDeleteComment() {
        Comment mainComment = new Comment("Main comment");
        Comment reply = new Comment("Reply to the main comment.");
        mainComment.reply(reply.getComment());

        // Delete a reply and check if it's deleted
        mainComment.deleteComment(reply.getID());
        assertEquals(0, mainComment.getComments().size());
    }

    @Test
    public void testEditComment() {
        Comment comment = new Comment("Original comment");
        UUID originalID = comment.getID();
        LocalDateTime originalTime = comment.getTime();

        comment.editComment("Edited comment");

        // Check if comment content is updated and time is changed
        assertNotEquals("Original comment", comment.getComment());
        assertNotEquals(originalTime, comment.getTime());
    }

    @Test
    public void testAuthorValidity() {
        Comment comment = new Comment("This is a comment.");
        assertTrue(comment.setAuthor(new User("John", "Doe", "john@example.com", "password")));

        // Set an invalid author
        assertFalse(comment.setAuthor(null));
    }

    @Test
    public void testCommentToString() {
        Comment mainComment = new Comment("Main comment");
        Comment reply = new Comment("Reply to the main comment.");
        mainComment.reply(reply.getComment());

        // Check the string representation of the comment
        String expectedString = "\n Comment: Main comment\n Author: null\n Sub-Comments: [" + reply.toString() + "]";
        assertEquals(expectedString, mainComment.toString());
    }
}