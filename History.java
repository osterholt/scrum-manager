import java.util.ArrayList;
/**
 * @author Evelyn Ellis
 * @version v1.0
 * Date: 10/12/2023
 */
public class History {

    private static History history;
    private ArrayList<Update> entries;

    private History(){

    }
    public History getInstance(){
        return history;
    }
    public ArrayList<Update> getHistory(){
        return entries;
    }
    public Update getHistory(int id){
        return null;
    }
    public boolean updateHistory(Update change){
    return false;
    }
    public Update removeChange(int id){
        return null;
    }
    
    
}