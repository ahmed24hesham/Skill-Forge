package BackEnd;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class StudentDB extends JsonDatabaseManager {
//        Type studentListType = new TypeToken<ArrayList<Srudent>>() {}.getType();
//        JsonDatabaseManager<Srudent> studentDB = new JsonDatabaseManager<>("users.json", studentListType);   
    public StudentDB(String fileName, Type typeOfT) {
        super(fileName, typeOfT);
    }

    /**
     *
     * @param s
     */
    public void addStudent(Srudent s){
      ArrayList<Srudent> l = load();
        for(Srudent x : l){
            if(x.getUsername().equals(s.getUsername())){
                return;
            }   
        }
        add(s);
    }
}

    

