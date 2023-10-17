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
    private UUID id;

    public Update(Date timeStamp, User user, String changeLog, UUID id){
        this.id = UUID.randomUUID();
        this.user = user;
        this.changelog = changeLog;
        this.timestamp = timeStamp;
      }
  
      public UUID getId() {
          return id;
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
      public void setTimeStamp(Date timeStamp) {
      this.timestamp = timeStamp;
      }
      public void setUser(User user) {
          
      }
      public String setChangeLog(String changelog) {
          return changelog;
      }
    
}
