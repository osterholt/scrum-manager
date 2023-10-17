import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public static void savePeople() { 
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getId().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_EMAIL, user.getEmail());
        userDetails.put(USER_PASSWORD, user.getPassword());

        JSONArray companyList = new JSONArray();
        for (Company company : user.getCompanies()) {
            companyList.add(company.getID().toString());
        }

        userDetails.put(USER_COMPANIES, companyList);

        return userDetails;
    }


    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("Josh", "Dietrich", "jdd@email.com", "password1");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password2");
        User user3 = new User("evie", "ellis", "ee@email.com", "password3");
        Company company1 = new Company("USC Ltd", user3, null, null);
        Company company2 = new Company("Company 2", user3, null, null);
        Company company3 = new Company("COmpany 3", user3, null, null);

        user1.addCompany(company1);
        user1.addCompany(company2);
        user1.addCompany(company3);
        user2.addCompany(company1);
        user2.addCompany(company2);
        user2.addCompany(company3);
        user3.addCompany(company1);
        user3.addCompany(company2);
        user3.addCompany(company3);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        JSONArray jsonUsers = new JSONArray();
        for(int i=0; i< users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}