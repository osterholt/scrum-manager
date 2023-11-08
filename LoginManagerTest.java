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

class LoginManagerTest {
	
	@BeforeClass
	public void oneTimeSetup() {
		
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
		//runs before each test
	}
	
	@AfterEach
	public void tearDown() {
		//runs after each test
	}
	
	
	@Test
	public void testCheckEmail() {
		// testing null
		boolean nullMail = LoginManager.getInstance().checkEmail(null);
		assertEquals(false, nullMail, "NULL EMAIL IS FALSE");
		// testing string that says null
		boolean wrongNullMail = LoginManager.getInstance().checkEmail("NULL");
		assertEquals(false, wrongNullMail, "NULL STRING EMAIL IS FALSE");
		// testing a different string
		boolean wrongMail = LoginManager.getInstance().checkEmail("RICKANDMORTYRICKRICK");
		assertEquals(false, wrongMail, "RICKANDMORTYRICKRICK STRING EMAIL IS FALSE");
		// testing email that should work
		boolean goodMail = LoginManager.getInstance().checkEmail("EVIE.ELLIS11@GMAIL.COM");
		assertEquals(true, goodMail, "EVIE.ELLIS11@GMAIL.COM STRING EMAIL IS TRUE");
		// lower case
		boolean lowerCaseMail = LoginManager.getInstance().checkEmail("evie.ellis11@gmail.com");
		assertEquals(true, lowerCaseMail, "evie.ellis11@gmail.com STRING EMAIL IS TRUE");
		// no @ symbol
		boolean noAtMail = LoginManager.getInstance().checkEmail("EVIE.ELLIS11GMAIL.COM");
		assertEquals(false, noAtMail, "EVIE.ELLIS11GMAIL.COM STRING EMAIL IS FALSE");
		// no username
		boolean noUsernameMail = LoginManager.getInstance().checkEmail("@GMAIL.COM");
		assertEquals(false, noUsernameMail, "@GMAIL.COM STRING EMAIL IS FALSE");
		// no mail server
		boolean noMailServerMail = LoginManager.getInstance().checkEmail("EVIE.ELLIS11@.COM");
		assertEquals(false, noMailServerMail, "EVIE.ELLIS11@.COM STRING EMAIL IS FALSE");
		// no domain
		boolean noDomainMail = LoginManager.getInstance().checkEmail("EVIE.ELLIS11@GMAIL");
		assertEquals(false, noDomainMail, "EVIE.ELLIS11@GMAIL STRING EMAIL IS FALSE");
		// multiple dots in mail server
		boolean multiDotMail = LoginManager.getInstance().checkEmail("ee13@mailbox.sc.edu");
		assertEquals(true, multiDotMail, "ee13@mailbox.sc.edu STRING EMAIL IS TRUE");
		// invalid character
		boolean invalidCharMail = LoginManager.getInstance().checkEmail("$$$$$$$$@GMAIL.COM");
		assertEquals(false, invalidCharMail, "$$$$$$$$@GMAIL.COM STRING EMAIL IS FALSE");
		// testing email which is already in the list, same capitalization
		LoginManager.getInstance().addUser(new User("Evie", "Ellis", "evie.ellis11@gmail.com", "password"));
		boolean userAlreadyExistsMail = LoginManager.getInstance().checkEmail("evie.ellis11@gmail.com");
		assertEquals(false, userAlreadyExistsMail, "evie.ellis11@gmail.com STRING EMAIL IS FALSE");
		// testing email which is already in the list, different capitalization
		boolean userAlreadyExistsCapitalMail = LoginManager.getInstance().checkEmail("EVIE.ELLIS11@GMAIL.COM");
		assertEquals(false, userAlreadyExistsCapitalMail, "EVIE.ELLIS11@GMAIL.COMSTRING EMAIL IS FALSE");

	}

    @Test
	public void testCheckPassword() {
		// testing null
		boolean nullPass = LoginManager.getInstance().checkPassword(null);
		assertEquals(false, nullPass, "NULL PASSWORD IS FALSE");
		// testing string null
		boolean nullStringPass = LoginManager.getInstance().checkPassword("null");
		assertEquals(false, nullStringPass, "NULL PASSWORD IS FALSE");
		// seven character password
		boolean sevenPass = LoginManager.getInstance().checkPassword("passwor");
		assertEquals(false, sevenPass, "passwor PASSWORD IS FALSE");
		// eight character password
		boolean eightPass = LoginManager.getInstance().checkPassword("password");
		assertEquals(true, eightPass, "password PASSWORD IS TRUE");
		// special & regular character password
		boolean mixedCharPass = LoginManager.getInstance().checkPassword("1L0v3P1$$");
		assertEquals(true, mixedCharPass, "1L0v3P1$$ PASSWORD IS TRUE");
	}

    @Test
	public void testGetUser() {
		LoginManager.getInstance().addUser(new User("Evie", "Ellis", "evie.ellis11@gmail.com", "password"));
		User user = LoginManager.getInstance().getUser("evie.ellis11@gmail.com", "password");
		//assertEquals(true, eightPass, "password PASSWORD IS TRUE");
		// TODO
	}

    @Test
	public void testPrintUsers() {
		// TODO
	}
	
}