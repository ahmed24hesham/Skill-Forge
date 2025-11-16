package BackEnd;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Instructor extends User{

    public Instructor(String userId, String role, String username, String email, String passwordHash) {
        super(userId, role, username, email, passwordHash);
        
    }
    
    public void add (Course c ){
            Type courseListType = new TypeToken<ArrayList<Course>>() {}.getType();
    JsonDatabaseManager<Course> courseDB = new JsonDatabaseManager<>("courses.json", courseListType);
        courseDB.add(c);
        
    }

}   