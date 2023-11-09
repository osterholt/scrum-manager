import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 11/06/2023
 */
public class AppFacadeTest {

    @Test
    public void testGetInstance() {
        AppFacade appFacade1 = AppFacade.getInstance();
        AppFacade appFacade2 = AppFacade.getInstance();
        
        // Ensure the singleton instance is the same
        assertSame(appFacade1, appFacade2);
    }

    @Test
    public void testSetActiveUser() {
        AppFacade appFacade = AppFacade.getInstance();
        User testUser = new User("John", "Doe", "john@example.com", "password");
        assertTrue(appFacade.setActiveUser(testUser));
        assertEquals(testUser, appFacade.getActiveUser());
    }

    @Test
    public void testLoginWithValidCredentials() {
        AppFacade appFacade = AppFacade.getInstance();
        appFacade.signUp("Evie", "Ellis","validUsername@gmail.com", "validPassword");
        assertTrue(appFacade.login("validUsername@gmail.com", "validPassword"));
        assertNotNull(appFacade.getActiveUser());
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        AppFacade appFacade = AppFacade.getInstance();
        // Assuming the user doesn't exist in LoginManager
        assertFalse(appFacade.login("invalidUsername", "invalidPassword"));
        assertNull(appFacade.getActiveUser());
    }

    @Test
    public void testSignUpAndGetCurrentUser() {
        AppFacade appFacade = AppFacade.getInstance();
        UUID userId = appFacade.signUp("Alice", "Smith", "alice@example.com", "pass123");
        assertNotNull(userId);
        assertEquals("Alice", appFacade.getCurrentUser().getFirstName());
    }


    @Test
    public void testSetActiveCompanyWithName() {
        AppFacade appFacade = AppFacade.getInstance();
		appFacade.signUp("Evie", "Ellis","validUsername@gmail.com", "validPassword");
        assertTrue(appFacade.setActiveCompany(new Company("ExampleCompany")));
        assertEquals("ExampleCompany", appFacade.getActiveCompany().getName());
    }

    @Test
    public void testSetActiveCompanyWithObject() {
        AppFacade appFacade = AppFacade.getInstance();
        Company testCompany = new Company("TestCompany");
        assertTrue(appFacade.setActiveCompany(testCompany));
        assertEquals(testCompany, appFacade.getActiveCompany());
    }

    @Test
    public void testSetActiveBoard() {
        AppFacade appFacade = AppFacade.getInstance();
        appFacade.signUp("Evie", "Ellis","validUsername@gmail.com", "validPassword");
		appFacade.setActiveCompany(new Company("ExampleCompany"));
		Board board = new Board("ExampleBoard", false);
		appFacade.getActiveCompany().addBoard(board);
        assertTrue(appFacade.setActiveBoard("ExampleBoard"));
        assertNotNull(appFacade.getActiveBoard());
    }

    @Test
    public void testToString() {
		AppFacade.getInstance().login("jane@example.com", "pass456");
        AppFacade appFacade = AppFacade.getInstance();
        // Assuming activeUser, activeCompany, and activeBoard are set
        appFacade.setActiveUser(new User("Jane", "Doe", "jane@example.com", "pass456"));
        appFacade.setActiveCompany(new Company("AnotherCompany"));
		Board board = new Board("AnotherBoard", false);
		appFacade.getActiveCompany().addBoard(board);
        appFacade.setActiveBoard("AnotherBoard");
        String expected = "\nActive User: Jane Doe\nActive Company: AnotherCompany\nActive Board: AnotherBoard";
        assertEquals(expected, appFacade.toString());
    }
}
