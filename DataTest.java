import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Joshua Dietrich
 * @date 11/08/2023
 * 
 * Couldn't figure out how to erase data without deleting and remaking the json file,
 * so the tests work when run individually, but not all together
 * 
 * No issues with testing User data reading and writing
 * 
 * Encountered bug when trying to run Company tests, for some reason Company data isnt being written,
 * attempted to fix but couldn't figure it out this time, will attempt again
 * 
 * Company bug means can't run company tests, but I guess thats the point of testing
 */
public class DataTest {
    private LoginManager loginManager = LoginManager.getInstance();
	private ArrayList<User> userList = loginManager.getUsers();
    private CompanyManager companyManager = CompanyManager.getInstance();
    private ArrayList<Company> companyList = companyManager.getCompanies();
	
	@BeforeEach
	public void setup() {
		loginManager.getUsers().clear();
        companyManager.getCompanies().clear();
		DataWriter.saveUsers();
        DataWriter.saveCompanies();
	}
	
	@AfterEach
	public void tearDown() {
		loginManager.getUsers().clear();
        companyManager.getCompanies().clear();
		DataWriter.saveUsers();
        DataWriter.saveCompanies();
	}

    @Test
	public void testWritingZeroUsers() {
		userList = DataWriter.getUsers();
		assertEquals(0, userList.size());
	}

    @Test
	public void testWritingOneUser() {
		userList.add(new User("Josh", "Dietrich", "jdietrich@gmail.com", "password1"));
		DataWriter.saveUsers();
		assertEquals("jdietrich@gmail.com", DataWriter.getUsers().get(0).getEmail());
	}

    @Test
	public void testWritingTwoUsers() {
		userList.add(new User("evie", "Ellis", "eellis@gmail.com", "password2"));
		userList.add(new User("Cam", "Osterholt", "costerholt@gmail.com", "password3"));
		DataWriter.saveUsers();
		assertEquals("eellis@gmail.com", DataWriter.getUsers().get(1).getEmail());
	}

    @Test
	public void testWritingEmptyUser() {
		userList.add(new User("", "", "", ""));
		DataWriter.saveUsers();
		assertEquals(null, DataWriter.getUsers().get(3).getEmail());
	}
	
	@Test
	public void testWritingNullUser() {
		userList.add(new User("", "", null, ""));
		DataWriter.saveUsers();
		assertEquals(null, DataWriter.getUsers().get(4).getEmail());
	}
    @Test
	public void testWritingBadPassword() {
		userList.add(new User("James", "Gardner", "jgardner@gmail.com", "fd"));
		DataWriter.saveUsers();
		assertEquals(null, DataWriter.getUsers().get(3).getPassword());
	}
    @Test
    public void testWritingBadEmail() {
		userList.add(new User("J", "Lillard", "j", "password5"));
		DataWriter.saveUsers();
		assertEquals(null, DataWriter.getUsers().get(4).getEmail());
	}

    @Test
    public void testWritingZeroCompanies() {
        companyList = DataWriter.getCompanies();
        DataWriter.saveCompanies();
        assertEquals(0, companyList.size());
    }

    @Test
    public void testWritingOneCompany() {
        Company c = new Company("Company1");
        c.addUser(new User("Jim", "Lillard", "jimlil@gmail.com", "password6"));
        companyList.add(c);
        DataWriter.saveCompanies();
        assertEquals("Company1", DataWriter.getCompanies().get(0).getName());
    }

    @Test
    public void testWritingThreeCompany() {
        Company c1 = new Company("Company1");
        Company c2 = new Company("Company2");
        Company c3 = new Company("Company3");
        c1.addUser(new User("Sam", "L", "sl@gmail.com", "password8"));
        c2.addUser(new User("Carson", "D", "cd@gmail.com", "password9"));
        c3.addUser(new User("Olivia", "H", "oh@gmail.com", "password10"));
        companyList.add(c1);
        companyList.add(c2);
        companyList.add(c3);
        DataWriter.saveCompanies();
        assertEquals("Company1", DataWriter.getCompanies().get(0).getName());
    }

    @Test
    public void testWritingTasks() {
        AppFacade.getInstance().login("jdietrich@gmail.com", "password1");
        User user1 = new User("John", "L", "jl@email.com", "password11");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password12");
        Category cat =Category.FRONTEND;
        Task t1 = new Task(UUID.randomUUID(), "taskname", "taskdescription", LocalDateTime.now(), user1, user2, cat, false, 1, 1);
        Task t2 = new Task(UUID.randomUUID(), "taskname2", "taskdescription2", LocalDateTime.now(), user1, user2, cat, false, 1, 1);
        Column column = new Column("Todo", "Tasks that need to be done");
        column.addTask(t1);
        column.addTask(t2);
        Board board = new Board("Test Board", "description",true);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        board.getColumn("Todo").addTask(t1);
        board.getColumn("Todo").addTask(t2);
        Company company = new Company("Test Company", user1, users, UUID.randomUUID());
        company.addBoard(board);
        companyManager.addCompany(company);
        DataWriter.saveTasks();
        assertEquals("taskname", DataWriter.getTasks().get(0).getName());
    }

    @Test
    public void testWritingEmptyTask() {
        AppFacade.getInstance().login("jdietrich@gmail.com", "password1");
        User user1 = new User("John", "L", "jl@email.com", "password11");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password12");
        Category cat =Category.FRONTEND;
        Task t1 = new Task(UUID.randomUUID(), "", "", LocalDateTime.now(), user1, user2, cat, false, 1, 1);
        Column column = new Column("Todo", "Tasks that need to be done");
        column.addTask(t1);
        Board board = new Board("Test Board", "description",true);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        board.getColumn("Todo").addTask(t1);
        Company company = new Company("Test Company", user1, users, UUID.randomUUID());
        company.addBoard(board);
        companyManager.addCompany(company);
        DataWriter.saveTasks();
        assertEquals("", DataWriter.getTasks().get(0).getName());
    }

    @Test
    public void testWritingNullTask() {
        AppFacade.getInstance().login("jdietrich@gmail.com", "password1");
        User user1 = new User("John", "L", "jl@email.com", "password11");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password12");
        Category cat =Category.FRONTEND;
        Task t1 = new Task(UUID.randomUUID(), null, null, null, user1, user2, cat, false, 1, 1);
        Column column = new Column("Todo", "Tasks that need to be done");
        column.addTask(t1);
        Board board = new Board("Test Board", "description",true);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        board.getColumn("Todo").addTask(t1);
        Company company = new Company("Test Company", user1, users, UUID.randomUUID());
        company.addBoard(board);
        companyManager.addCompany(company);
        DataWriter.saveTasks();
        assertEquals(null, DataWriter.getTasks().get(0).getName());
    }

    @Test
    public void testWritingTaskComment() {
        AppFacade.getInstance().login("jdietrich@gmail.com", "password1");
        User user1 = new User("John", "L", "jl@email.com", "password11");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password12");
        Category cat =Category.FRONTEND;
        Task t1 = new Task(UUID.randomUUID(), null, null, null, user1, user2, cat, false, 1, 1);
        t1.addComment("Comment1");
        Column column = new Column("Todo", "Tasks that need to be done");
        column.addTask(t1);
        Board board = new Board("Test Board", "description",true);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        board.getColumn("Todo").addTask(t1);
        Company company = new Company("Test Company", user1, users, UUID.randomUUID());
        company.addBoard(board);
        companyManager.addCompany(company);
        DataWriter.saveTasks();
        assertEquals("Comment1", DataWriter.getTasks().get(0).getComments().get(0).getComment());
    }

    @Test
    public void testWritingTaskHistory() {
        AppFacade.getInstance().login("jdietrich@gmail.com", "password1");
        User user1 = new User("John", "L", "jl@email.com", "password11");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password12");
        Category cat =Category.FRONTEND;
        Task t1 = new Task(UUID.randomUUID(), null, null, LocalDateTime.now(), user1, user2, cat, false, 1, 1);
        History h = new History(null, user2, "change");
        ArrayList<History> hist= new ArrayList<>();
        hist.add(h);
        t1.setHistory(hist);
        Column column = new Column("Todo", "Tasks that need to be done");
        column.addTask(t1);
        Board board = new Board("Test Board", "description",true);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        board.getColumn("Todo").addTask(t1);
        Company company = new Company("Test Company", user1, users, UUID.randomUUID());
        company.addBoard(board);
        companyManager.addCompany(company);
        DataWriter.saveTasks();
        assertEquals("change", DataWriter.getTasks().get(0).getHistory().get(0).getChange());
    }
}
