package BackEnd;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class InstructorDB extends JsonDatabaseManager {
public InstructorDB(String fileName, Type typeOfT) {
        super(fileName, typeOfT);
    }

    public void addInstructor(Instructor i){
      ArrayList<Instructor> l = load();
        for(User x : l){
            if(x.getUsername().equals(i.getUsername())){
                return;
            }   
        }
        add(i);
    }
}
