package BackEnd;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CourseDB extends JsonDatabaseManager{

    public CourseDB(String fileName, Type typeOfT) {
        super(fileName, typeOfT);
    }
    public void addcourse(Course c){
      ArrayList<Course> l = load();
        for(Course x : l){
            if(x.getCourseId().equals(c.getCourseId())){
                return;
            }   
        }
        add(c);
    } 
        public void remove(Course c){
       ArrayList<Course> list = load();
       for(Course st : list){
           if(st.getCourseId().equals(c.getCourseId())){
               list.remove(st);
           }
            System.out.println("5555555555");
       save(list);
    }
    }
}
