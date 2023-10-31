import java.util.ArrayList;
import java.util.UUID;
/**
 * @author Gavin Hewitt
 * @version "v1.0"
 * Date: 10/15/23
 */

public class CompanyManager {
  private static CompanyManager companyManager;
  private static ArrayList<Company> companies;

  private CompanyManager() {
    companies = new ArrayList<Company>();
  }

  public static CompanyManager getInstance() {
    if(companyManager == null)
      companyManager = new CompanyManager();
    return companyManager;
  }

  /**
   * Checks if Company to be added is present in list and a valid company and
   * adds to the list of Companies if true.
   * @param company Company to be added
   * @return boolean if successfully added
   */
  public boolean addCompany(Company company) {
    for(Company currCompany : companies) {
      if(currCompany.equals(company))
        return false;
    }
    companies.add(company);
    AppFacade.getInstance().setActiveCompany(company);
    return true;
  }

  /**
   * Iterates through ArrayList of Company objects and removes the specified
   * Company if present.
   * @param company Company to be removed
   * @return Company removed
   */
  public Company removeCompany(Company company) {
    for(Company currCompany : companies) {
      if(currCompany.equals(company)) {
        companies.remove(currCompany);
        return currCompany;
      }
    }
    return null;
  } 

  public static Company getCompany(UUID id) {
    for(Company company : companies) {
      if(id.equals(company.getID()))
        return company;
    }
    return null;
  }

  public static Company getCompany(String name) {
    for(Company company : companies) {
      if(name.toLowerCase().equals(company.getName().toLowerCase()))
        return company;
    }
    return null;
  }

	public ArrayList<Company> getCompanies() {
		return companies;
	}

  public static boolean saveCompanies() {
    return DataWriter.saveCompanies();
  }
}