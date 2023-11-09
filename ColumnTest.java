import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Sherry Begay
 * @version v1.0
 * Date: 11/7/2023
 */

public class ColumnTest {

    private Column column;

    @BeforeEach
    public void setUp() {
        // Initialize a fresh Column instance before each test
        column = new Column("Test Column", "Test Description");
    }

    @Test
    public void testSetTitle() {
        // this test checks that setTitle sets a new title
        // add test cases to check if invalid 
        assertTrue(column.setTitle("New Title"));
        assertEquals("New Title", column.getTitle());
    }

    @Test
    public void testSetDescription() {
        // set a new description but doesn't verify potential failures
        // add test cases to check if invalid
        assertTrue(column.setDescription("New Description"));
        assertEquals("New Description", column.getDescription());
    }

    @Test
    public void testAddTask() {
        // checks if added but doesn't handle scenarios 
        // add test cases to verify that task addition is provided
        Task task = new Task(UUID.randomUUID(), "Test Task", "Task Description", LocalDateTime.now(), null, null, null, false, 1, 0.0f);
        assertTrue(column.addTask(task));
    }

    @Test
    public void testAddTaskWithName() {
        // Issue: test checks if a task can be added by name but doesn't verify failures
        assertTrue(column.addTask("Test Task"));
    }

    @Test
    public void testGetTaskById() {
        // test checks if a task can be retrieved by ID
        // Action: add test cases to handle scenarios
        UUID taskId = UUID.randomUUID();
        Task task = new Task(taskId, "Test Task", "Task Description", LocalDateTime.now(), null, null, null, false, 1, 0.0f);
        column.addTask(task);

        Task retrievedTask = column.getTask(taskId);
        assertNotNull(retrievedTask);
        assertEquals(task, retrievedTask);
    }

    @Test
    public void testGetTaskByName() {
        // this test checks if a task can be retrieved by name
        // add test cases to handle scenarios 
        String taskName = "Test Task";
        Task task = new Task(UUID.randomUUID(), taskName);
        column.addTask(task);

        Task retrievedTask = column.getTask(taskName);
        assertNotNull(retrievedTask);
        assertEquals(task, retrievedTask);
    }

    @Test
    public void testRemoveTask() {
        String taskName = "Test Task";
        column.addTask(taskName);

        assertTrue(column.removeTask(taskName));
    }

    @Test
    public void testGetTasks() {
        // Make sure the list is not empty
        assertFalse(column.getTasks().isEmpty());

        Task task = new Task(UUID.randomUUID(), "Test Task Now");
        column.addTask(task);

        // Make sure the list contains the added task
        assertTrue(column.getTasks().contains(task));
    }

    @Test
    public void testTaskReorder() {
        Task task1 = new Task(UUID.randomUUID(), "Task 1");
        Task task2 = new Task(UUID.randomUUID(), "Task 2");
        column.addTask(task1);
        column.addTask(task2);

        assertTrue(column.taskReorder(1, task1)); // Move task1 to index 1

        assertEquals(task1, column.getTasks().get(1));
        assertEquals(task2, column.getTasks().get(2));
    }
}
