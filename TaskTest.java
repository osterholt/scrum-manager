import org.junit.Test;
import static org.junit.Assert.*;
import java.util.UUID;
import java.time.LocalDateTime;

/**
 * @author Gavin Hewitt
 * @version v1.0
 * Date: 11/08/23
 */
public class TaskTest {
    // users for task
    private static User gavin = new User("Gavin", "Hewitt", "ghewitt@email.sc.edu", "password");
    private static User shan = new User("Shannon", "DePratter", "sdepratter@email.sc.edu", "password");
    // task for testing
    private static Task completeTesting = new Task(UUID.randomUUID(), "Complete Testing", "Finish unit testing for code!", LocalDateTime.now(), gavin, shan, Category.SOLO_PROJECT, false,
        1, (float)1.5);
    // test how task with minimal instantiation works
    private static Task undefinedTask = new Task("Undefined", gavin);
    // addComment - tested
    // deleteComment - tested
    // resolve - tested
    // get comment of a comment - fails in delete Comment test, add issue
    // addHistory - method doesn't exist, add issue

    @Test
    public void testAddComment() {
        // need to initialize activeUser in facade for comments to be added
        AppFacade.getInstance().setActiveUser(gavin);
        Comment firstComment = new Comment("This is my first comment!");
        // test that comment object is successfully added to both tasks
        boolean addFirstCommentToComplete = completeTesting.addComment(firstComment);
        boolean addFirstCommentToUndefined = undefinedTask.addComment(firstComment);
        assertTrue("First comment not added to complete", addFirstCommentToComplete); // fails, add issue (method only returns false, nullity check not needed due to ambiguity)
                                                    // need to ask portia, null could be cast as Comment or String and then we'd have problems, but can that happen natively in app?
        assertTrue("First comment not added to undefined", addFirstCommentToUndefined); // same failure
        // test that new comment can be added via string
        boolean addStringCommentToComplete = completeTesting.addComment("Testing string addition");
        boolean addStringCommentToUndefined = undefinedTask.addComment("Testing string addition");
        assertTrue("String comment not added to complete", addStringCommentToComplete);
        assertTrue("String comment not added to undefined", addStringCommentToUndefined);
        // test that string added is an actual comment object in the list
        Comment stringCommentComplete = completeTesting.getComment("Testing string addition");
        Comment stringCommentUndefined = undefinedTask.getComment("Testing string addition");
        assertSame("Testing string addition", stringCommentComplete.getComment());
        assertSame("Testing string addition", stringCommentUndefined.getComment());
    }

    @Test
    public void testRemoveComment() {
        // need to initialize activeUser in facade for comments to be added
        AppFacade.getInstance().setActiveUser(gavin);
        completeTesting.addComment("Testing string addition");
        undefinedTask.addComment("Testing string addition");
        completeTesting.getComment("Testing string addition").reply("This is a reply");
        undefinedTask.getComment("Testing string addition").reply("This is a reply");
        // delete reply comment test
        UUID completeReplyID = completeTesting.getComment("This is a reply").getID(); // can't access reply through task, only the root comment, need to add issue
        UUID undefinedReplyID = undefinedTask.getComment("This is a reply").getID(); 
        boolean deleteCompleteReply = completeTesting.deleteComment(completeReplyID);
        boolean deleteUndefinedReply = undefinedTask.deleteComment(undefinedReplyID);
        assertTrue("Reply not deleted in complete", deleteCompleteReply); 
        assertTrue("Reply not deleted in undefined", deleteUndefinedReply);
        // delete comment
        UUID completeCommentID = completeTesting.getComment("Testing string addition").getID();
        UUID undefinedCommentID = undefinedTask.getComment("Testing string addition").getID();
        boolean deleteCompleteComment = completeTesting.deleteComment(completeCommentID);
        boolean deleteUndefinedComment = undefinedTask.deleteComment(undefinedCommentID);
        assertTrue("Comment not deleted from complete", deleteCompleteComment);
        assertTrue("Comment not delted from undefined", deleteUndefinedComment);
    }

    @Test
    public void testResolve() {
        // AppFacade.getInstance().setActiveUser(gavin);
        // resolve task and test that it's true
        assertTrue("complete task not resolved", completeTesting.resolve());
        assertTrue("undefined task not resolved", undefinedTask.resolve());
    }
}
