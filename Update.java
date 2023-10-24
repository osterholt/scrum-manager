import java.sql.Date;
import java.util.UUID;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class Update {
    private Date timestamp;
    private User user;
    private String changelog;

    public Update(Date timeStamp, User user, String changeLog, UUID id){
        this.user = user;
        this.changelog = changeLog;
        this.timestamp = timeStamp;
      }
  
      public Date getTimeStamp() {
          return timestamp;
      }
      public User getUser() {
          return user;
      }
      public String getChangeLog() {
          return changelog;
      }
      public void setTimeStamp(Date timestamp) {
        this.timestamp = timestamp;
      }
      public void setUser(User user) {
          this.user = user;
      }
      public void setChangeLog(String changelog) {
        if(changelog == null) {
            System.out.println("Invalid log. change Failed.");
        }
        this.changelog = changelog;
      }
    
}
