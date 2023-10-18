import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants{
    public static void savePeople() { 
    }

    public void testUsers() {
        ArrayList<User> users = new ArrayList<User>();
        User user1 = new User("Josh", "Dietrich", "jdd@email.com", "password1");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password2");
        User user3 = new User("evie", "ellis", "ee@email.com", "password3");
        Company company1 = new Company("USC Ltd", user3, null, null);
        Company company2 = new Company("Company 2", user3, null, null);

        user1.addCompany(company1);
        user2.addCompany(company1);
        user3.addCompany(company1);
        user1.addCompany(company2);
        user2.addCompany(company2);
        user3.addCompany(company2);
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
    public static JSONObject getTaskJSON(Task task) {
       JSONObject taskDetails = new JSONObject();
       taskDetails.put(TASK_ID, task.getID().toString());
       taskDetails.put(TASK_NAME, task.getName());
       taskDetails.put(TASK_DESCRIPTION, task.getDescription());
       //taskDetails.put(TASK_DATE, task.getDate());
    //    taskDetails.put(TASK_AUTHOR_ID, task.getAuthorID()).toString();
    //    taskDetails.put(TASK_ASSIGNEE_ID, task.getAssignedID().toString());
       taskDetails.put(TASK_AUTHOR_ID, task.getAuthor().toString());
       taskDetails.put(TASK_ASSIGNEE_ID, task.getAssignee().toString());
       //taskDetails.put(TASK_CATEGORY, task.getCategory().toString());
       taskDetails.put(TASK_RESOLVED, task.isResolved());
       //taskDetails.put(TASK_PRIORITY, task.getPriority());
       taskDetails.put(TASK_TIME_REQUIRED, task.getTimeRequired());
    //    JSONObject historyDetails = new JSONObject();
    //    historyDetails.put(HISTORY_AUTHOR_ID, task.getHistory().getHistory().toString());
    //    historyDetails.put(HISTORY_CHANGE, task.getHistory());
        return taskDetails;
    }


    public static void main(String[] args) {
        DataWriter test = new DataWriter();
        test.testUsers();
        
        // ArrayList<Task> tasks = new ArrayList<Task>();
        // Task task1 = new Task(UUID.randomUUID(), "TaskName", "Description lalalal", user1, user2, false, 3);
        // Task task2 = new Task(UUID.randomUUID(), "TaskName", "Description lalalal", user1, user2, false, 3);
        // tasks.add(task1);
        // tasks.add(task2);
        // JSONArray jsonTasks = new JSONArray();
        // for(int i=0; i< tasks.size(); i++) {
		// 	jsonTasks.add(getTaskJSON(tasks.get(i)));
		// }
        // try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {
 
        //     file.write(jsonTasks.toJSONString());
        //     file.flush();
 
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
    }
}