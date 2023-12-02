import org.junit.Test;
import java.util.ArrayList;
import java.util.UUID;
import static org.junit.Assert.*;

/**
 * @author Gavin Hewitt
 * @version v1.0
 * Date: 11/6/23
 */
public class TestCompany {
    // admin users for each company
    private static User TimCook = new User("Tim", "Cook", "tcook@apple.com", "iphonebestphone100");
    private static User BillGates = new User("Bill", "Gates", "bgates@microsoft.com", "windowsxpstartup");
    private static User MarkZuck = new User("Mark", "Zuckerburg", "mzuckerburg@meta.com", "iammetaman");
    // company initialization to be used in tests
    private static Company Apple = new Company("Apple", TimCook, new ArrayList<User>(), UUID.randomUUID());
    private static Company Microsoft = new Company("Microsoft", BillGates, new ArrayList<User>(), UUID.randomUUID());
    private static Company Meta = new Company("Meta", MarkZuck, new ArrayList<User>(), UUID.randomUUID());
    
    @Test
    public void testAddUser() {
        // ensures adding a null user isn't possible
        boolean nullUser = Apple.addUser(null);
        assertFalse("nullUser is added", nullUser);
        // checks that adding a user works
        boolean addTim = Apple.addUser(BillGates);
        assertTrue("Tim Cook not added successfully", addTim);
        // checks adding a new user in method
        boolean addNew = Apple.addUser(new User(UUID.randomUUID(), "New", "Person", "newperson@gmail.com", "iamnewtothis", "software engineer"));
        assertTrue("New user not added successfully", addNew);
    }

    @Test
    public void testRemoveUser() {
        // can't remove a null user
        boolean nullUser = Apple.removeUser(null);
        assertFalse("attempted to remove null user", nullUser);
        Apple.addUser(TimCook);
        Apple.addUser(MarkZuck);
        // checks to see successfully removes user
        boolean removeMark = Apple.removeUser(MarkZuck);
        assertTrue("Mark was not removed", removeMark);
        // fails to remove a user that isn't in list
        boolean removeBill = Apple.removeUser(BillGates);
        assertFalse("Bill was somehow removed", removeBill);
    }

    @Test
    public void testAddBoard() {
        // must be done for Board to be initialized 
        AppFacade.getInstance().setActiveUser(TimCook);
        // cant add a null board
        boolean nullBoard = Microsoft.addBoard(null);
        assertFalse("null board added", nullBoard);
        // successfully adds valid board
        boolean microBoard = Microsoft.addBoard(new Board("Microsoft SCRUM", false));
        assertTrue("Microsoft Board not added", microBoard);
        // can't add a new board with description if board with same name already exists
        boolean microBoardDesc = Microsoft.addBoard(new Board("Microsoft SCRUM", "SCRUM Board for Microsoft development team", false));
        assertFalse("Microsoft Board with description added", microBoardDesc); // fails, need to add issue
        // can't add same board twice
        boolean microBoard2 = Microsoft.addBoard(new Board("Microsoft SCRUM", false));
        assertFalse("Microsoft Board added a second time", microBoard2); // fails, need to add issue
    }

    @Test
    public void testRemoveBoard() {
        // must be done to initalize Board object
        AppFacade.getInstance().setActiveUser(BillGates);
        // cant remove a null board
        boolean nullBoard = Microsoft.removeBoard(null);
        assertFalse("null board removed", nullBoard);
        // can't remove a board that isn't there
        boolean removeFakeBoard = Microsoft.removeBoard(new Board("Fake board", true));
        assertFalse("nonexistant board removed", removeFakeBoard);
        // successfully remove board
        Board funBoard = new Board("Fun Board", true);
        Microsoft.addBoard(funBoard);
        Microsoft.addBoard(new Board("decoy", true));
        boolean removeFunBoard = Microsoft.removeBoard(funBoard);
        assertTrue("board not removed", removeFunBoard);
    }

    @Test
    public void testAddAdmin() {
        // check that you can't add a user that is already an admin
        boolean addExistingAdmin = Meta.addAdmin(MarkZuck);
        assertFalse("Mark added twice", addExistingAdmin); // fails, need to add issue
        // successfully add new admin
        boolean addNewAdmin = Meta.addAdmin(TimCook);
        assertTrue("Tim made admin", addNewAdmin);
        // checks that when a user is made admin, they're added to user list
        boolean newAdminIsUser = Meta.getUsers().contains(TimCook);
        assertTrue("Tim is not also a user", newAdminIsUser); // fails, need to add issue
        // cant make null user an admin
        boolean nullAdmin = Meta.addAdmin(null);
        assertFalse("null is an admin", nullAdmin);
    }

    @Test
    public void testIsAdmin() {
        Meta.addAdmin(MarkZuck);
        boolean markIsAdmin = Meta.isAdmin(MarkZuck);
        assertTrue("Mark is not an admin", markIsAdmin);
    }

    

    @Test
    public void testRemoveAdmin() {
        // can't remove a null user
        boolean nullUser = Meta.removeAdmin(null);
        assertFalse("attempted to remove null admin", nullUser);
        Meta.addAdmin(TimCook);
        // checks to see successfully removes admin
        boolean removeTim = Meta.removeAdmin(TimCook);
        assertTrue("Tim was not removed", removeTim);
        // fails to remove a user that isn't in list
        boolean removeBill = Meta.removeAdmin(BillGates);
        assertFalse("Bill was somehow removed", removeBill);
        // checks that you can't remove the only admin
        boolean removeMark = Meta.removeAdmin(MarkZuck);
        assertFalse("Mark was removed as admin when he is the only one", removeMark); // fails, need to add issue and talk to team to make sure we don't want this
    }
}
