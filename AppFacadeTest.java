import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 11/06/2023
 */
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppFacadeTest {
	
	@BeforeClass
	public static void oneTimeSetup() {
		
	}
	
	@AfterClass
	public static void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public static void setup() {
		//runs before each test
	}
	
	@AfterEach
	public static void tearDown() {
		//runs after each test
	}
// 	- AppFacade(): void
// + getInstance(): AppFacade
// + getActiveUser(): User
// + setActiveUser(User active): boolean
// + getActiveBoard(): Board
// + login(String username, String password): boolean
// + getCurrentUser(): User
// - signUp(String firstName, String lastName, String email, String password): bool
// + getUser(UUID id): User
// + logOut(): void
// + getActiveCompany(): Company
// + setActiveCompany(String name): boolean
// + setActiveCompany(Company company): boolean
// + setActiveBoard(String name): boolean
// + toString(): String
	
	@Test
	public void testLogin() {
		// TODO
	}

    @Test
	public void testSignUp() {
		// TODO
	}

    @Test
	public void testLogOut() {
		// TODO
	}

    @Test
	public void testActiveUser() {
		// TODO
	}

    @Test
	public void testActiveBoard() {
		// TODO
	}

    @Test
	public void testActiveCompany() {
		// TODO
	}

    @Test
	public void testToString() {
		// TODO
	}

	
}