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

    public Update(Date timestamp, User user, String changelog, UUID id){
        this.id = UUID.randomUUID();
		this.user = user;
		this.timestamp = timestamp;
		this.changelog= changelog;
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
    public Date setTimeStamp() {
        this.timestamp = timestamp;
    }
    
}
