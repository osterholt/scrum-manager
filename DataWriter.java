import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataWriter extends DataConstants{

    //write users json
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

    //get useres json object to write it to the json file
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
    
    //data reader for users
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

    public static boolean saveTasks() {
        return true;
    }

    public static JSONObject getTaskJSON(Task task) {
        JSONObject taskDetails = new JSONObject();
        taskDetails.put(TASK_ID, task.getID().toString());
        taskDetails.put(TASK_NAME, task.getName());
        taskDetails.put(TASK_DESCRIPTION, task.getDescription());
        taskDetails.put(TASK_DATE, task.getDate());
       taskDetails.put(TASK_AUTHOR_ID, task.getAuthor().getId().toString());
       taskDetails.put(TASK_ASSIGNEE_ID, task.getAssignee().getId().toString());
       taskDetails.put(TASK_CATEGORY, task.getCategory().toString());
        taskDetails.put(TASK_RESOLVED, task.isResolved());
        taskDetails.put(TASK_PRIORITY, task.getPriority());
        taskDetails.put(TASK_TIME_REQUIRED, task.getTimeRequired());
        JSONArray historyArray = new JSONArray();
        for(History history : task.getHistory()) {
            JSONObject historyObject = new JSONObject();
            historyObject.put(HISTORY_AUTHOR_ID, history.getUser().getId().toString());
            historyObject.put(HISTORY_CHANGE, history.getChange());
            historyObject.put(HISTORY_DATE,history.getDate().toString());
            historyArray.add(historyObject);
        }
        taskDetails.put(TASK_HISTORY, historyArray);

        return taskDetails;
    }
    public static ArrayList<Task> getTasks() {
        ArrayList<Task> ret = new ArrayList<>();
        return ret;
    }
    public static void main(String[] args) {
       // ArrayList<User> userList = users.getUsers();
       ArrayList<Task> taskList = new ArrayList<>();
       User user1 = new User("Josh", "Dietrich", "jdd@email.com", "password1");
        User user2 = new User("Sherry", "begay", "shb@email.com", "password2");
        Category cat =Category.FRONTEND;
       Task t1 = new Task(UUID.randomUUID(), "taskname", "taskdescription", user1, user2, cat, false, 1, 1);
       Date currentDate = new Date();
       History h1 = new History(currentDate, user2, "change");
       ArrayList<History> histarray= new ArrayList<>();
       histarray.add(h1);
       t1.setHistory(histarray);
       JSONArray jsonTasks = new JSONArray();
        taskList.add(t1);
        for(int i=0; i< taskList.size(); i++) {
			jsonTasks.add(getTaskJSON(taskList.get(i)));
		}
        try (FileWriter file = new FileWriter(TASK_FILE_NAME)) {
 
            file.write(jsonTasks.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    }
}