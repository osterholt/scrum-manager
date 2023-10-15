import java.util.ArrayList;
/**
 * @author Gavin Hewitt
 * @version "v1.0"
 * Date: 10/15/23
 */

public class CompanyManager {
  private static CompanyManager companyManager;
  private ArrayList<Company> companies;

  private CompanyManager() {

  }

  public CompanyManager getInstance() {
    return companyManager;
  }

  public boolean addCompany(Company company) {
    return false;
  }

  public Company removeCompany(Company company) {
    return company;
  }
}