import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Cam Osterholt
 * @date 11/08/2023
 * 
 * I love unit testing (all the other tests are failing)
 */

public class BoardTest {
    private final String[] USER = {"cam@osterholt.us", "password"};
    // private Board testBoard;
    // private UUID taskID;
    private final String BOARD_NAME = "Test Board";
    private final String COLUMN_NAME = "Free Thug";
    private final String TASK_NAME1 = "Task #1";

    // private Board getTestBoard() {
    //     if(testBoard == null)
    //         testBoard = new Board(BOARD_NAME, true);
    //     return testBoard;
    // }

    private boolean login() {
        if(AppFacade.getInstance().getActiveUser() == null)
            return AppFacade.getInstance().login(USER[0], USER[1]);
        return AppFacade.getInstance().getActiveUser() != null;
    }

    @Test
    public void testCreateTask() {
        if(!login())
            Assert.fail();
        Board board = new Board(BOARD_NAME, true);
        boolean ret = board.createTask(TASK_NAME1);
        Assert.assertTrue(ret);
    }

    @Test
    public void testGetTask() {
        if(!login())
            Assert.fail();
        Board board = new Board(BOARD_NAME, true);
        board.createTask(TASK_NAME1);
        Task task = board.getTask(TASK_NAME1);
        Assert.assertEquals(task.getName(), TASK_NAME1);
    }

    @Test
    public void testMoveTask() {
        if(!login())
            Assert.fail();
        Board board = new Board(BOARD_NAME, true);
        board.createTask(TASK_NAME1);
        Assert.assertTrue(board.moveTask(board.getColumn(0).getTitle(), board.getColumn(1).getTitle(), TASK_NAME1));
    }

    @Test
    public void testCompleteTask() {
        if(!login())
            Assert.fail();
        Board board = new Board(BOARD_NAME, true);
        board.createTask(TASK_NAME1);
        Task task = board.getTask(TASK_NAME1);
        Assert.assertTrue(board.completeTask(task.getID()));
    }

    @Test
    public void testDeleteTask() {
        if(!login())
            Assert.fail();
        Board board = new Board(BOARD_NAME, true);
        board.createTask(TASK_NAME1);
        Assert.assertTrue(board.deleteTask(null, TASK_NAME1));
    }

    @Test
    public void testCreateColumn() {
        if(!login())
            Assert.fail();
        Board board = new Board(BOARD_NAME, true);
        Assert.assertTrue(board.createColumn(COLUMN_NAME));
    }

    @Test
    public void testGetColumn() {
        if(!login())
            Assert.fail();
        Board board = new Board(BOARD_NAME, true);
        board.createColumn(COLUMN_NAME);
        Assert.assertNotNull(board.getColumn(COLUMN_NAME));
    }
}
