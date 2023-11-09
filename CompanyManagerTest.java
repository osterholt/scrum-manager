import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sherry Begay
 * @version v1.0
 * Date: 11/7/2023
 */

public class CompanyManagerTest {

    private CompanyManager companyManager;

    @BeforeEach
    public void setUp() {
        // Initialize a new CompanyManager instance before each
        companyManager = CompanyManager.getInstance();
    }

    @Test
    public void testAddCompany() {
        Company company = new Company(UUID.randomUUID(), "Test Company");
        assertTrue(companyManager.addCompany(company));
    }

    @Test
    public void testRemoveCompany() {
        Company company = new Company(UUID.randomUUID(), "Test Company");
        companyManager.addCompany(company);

        assertNotNull(companyManager.removeCompany(company));
    }

    @Test
    public void testGetCompanyById() {
        UUID companyId = UUID.randomUUID();
        Company company = new Company(companyId, "Test Test Company");
        companyManager.addCompany(company);

        Company retrievedCompany = companyManager.getCompany(companyId);
        assertNotNull(retrievedCompany);
        assertEquals(company, retrievedCompany);
    }

    @Test
    public void testGetCompanyByName() {
        String companyName = "Test Company";
        Company company = new Company(UUID.randomUUID(), companyName);
        companyManager.addCompany(company);

        Company retrievedCompany = companyManager.getCompany(companyName);
        assertNotNull(retrievedCompany);
        assertEquals(company, retrievedCompany);
    }

    @Test
    public void testGetCompanies() {
        // Make sure the list is not empty initially
        assertFalse(companyManager.getCompanies().isEmpty());

        Company company = new Company(UUID.randomUUID(), "Test Company");
        companyManager.addCompany(company);

        // Make sure the list contains the added company
        assertTrue(companyManager.getCompanies().contains(company));
    }

    @Test
    public void testSaveCompanies() {
        // You can test saving companies to persistent storage here
        // Ensure that DataWriter.saveCompanies() returns true on success
    }
}
