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

class CommentTest {
	
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
	
//     + Comment(String comment)
// + reply(Author author, String comment): void
// - init(): void
// + getID(): UUID
// - setID(UUID id): boolean
// + getTIme(): LocalDateTime
// + setTime(LocalDateTIme time): void
// + getComment(): String
// + editComment(String comment):void
// + getAuthor(): User
// + setAuthor(User author): boolean
// + getComments(): ArrayList<Comment>
// + deleteComment(UUID id): boolean
	
	@Test
	public void testReply() {
		// TODO
	}

    @Test
	public void testEditComment() {
		// TODO
	}

    @Test
	public void testAuthor() {
		// TODO
	}

    @Test
	public void testDate() {
		// TODO
	}

    @Test
	public void testID() {
		// TODO
	}

    @Test
	public void testGetComments() {
		// TODO
	}

    @Test
	public void testToString() {
		// TODO
	}
	
}