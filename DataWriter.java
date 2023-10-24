import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants{

    public static boolean saveUsers() {
        LoginManager users = LoginManager.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();
        for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
 
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean saveCompanies() {
        CompanyManager companies = CompanyManager.getInstance();
        ArrayList<Company> companyList = companies.getCompanies();
        JSONArray jsonUsers = new JSONArray();
        for(int i=0; i< companyList.size(); i++) {
            jsonUsers.add(getUserJSON(companyList.get(i)));
        }
        try (FileWriter file = new FileWriter(COMPANY_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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
    
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray userJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i < userJSON.size(); i++) {
			    JSONObject personJSON = (JSONObject)userJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String firstName = (String)personJSON.get(USER_FIRST_NAME);
                String lastName = (String)personJSON.get(USER_LAST_NAME);
                String email = (String)personJSON.get(USER_EMAIL);
                String role = (String)personJSON.get(USER_ROLE);
                String password = (String)personJSON.get(USER_PASSWORD);
                users.add(new User(id,firstName, lastName, email, password, role));
            }

            return users;
        } catch (Exception e) {
			e.printStackTrace();
		}
        return null;
    }

    // public void testUsers() {
    //     ArrayList<User> users = new ArrayList<User>();
    //     User user1 = new User("Josh", "Dietrich", "jdd@email.com", "password1");
    //     User user2 = new User("Sherry", "begay", "shb@email.com", "password2");
    //     User user3 = new User("evie", "ellis", "ee@email.com", "password3");
    //     Company company1 = new Company("USC Ltd", user3, null, null);
    //     Company company2 = new Company("Company 2", user3, null, null);

    //     user1.addCompany(company1);
    //     user2.addCompany(company1);
    //     user3.addCompany(company1);
    //     user1.addCompany(company2);
    //     user2.addCompany(company2);
    //     user3.addCompany(company2);
    //     users.add(user1);
    //     users.add(user2);
    //     users.add(user3);
    //     JSONArray jsonUsers = new JSONArray();
    //     for(int i=0; i< users.size(); i++) {
	// 		jsonUsers.add(getUserJSON(users.get(i)));
	// 	}
    //     try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
 
    //         file.write(jsonUsers.toJSONString());
    //         file.flush();
 
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }

    


    // public static void main(String[] args) {
    //     DataWriter test = new DataWriter();
    //     test.testUsers();
        
    //     // ArrayList<Task> tasks = new ArrayList<Task>();
    //     // Task task1 = new Task(UUID.randomUUID(), "TaskName", "Description lalalal", user1, user2, false, 3);
    //     // Task task2 = new Task(UUID.randomUUID(), "TaskName", "Description lalalal", user1, user2, false, 3);
    //     // tasks.add(task1);
    //     // tasks.add(task2);
    //     // JSONArray jsonTasks = new JSONArray();
    //     // for(int i=0; i< tasks.size(); i++) {
	// 	// 	jsonTasks.add(getTaskJSON(tasks.get(i)));
	// 	// }
    //     // try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {
 
    //     //     file.write(jsonTasks.toJSONString());
    //     //     file.flush();
 
    //     // } catch (IOException e) {
    //     //     e.printStackTrace();
    //     // }
    // }
}