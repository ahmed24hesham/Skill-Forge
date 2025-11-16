package BackEnd;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
//
//        // --- Students ---
//        Type studentListType = new TypeToken<ArrayList<Srudent>>() {}.getType();
//        JsonDatabaseManager<Srudent> studentDB = new JsonDatabaseManager<>("users.json", studentListType);
//
//        Srudent s = new Srudent("Ahmed", "A123");
//        studentDB.add(s); // adds to students.json

        // --- Instructors ---
        Type instructorListType = new TypeToken<ArrayList<Instructor>>() {}.getType();
        JsonDatabaseManager<Instructor> instructorDB = new JsonDatabaseManager<>("users.json", instructorListType);

        Instructor i = new Instructor("U100" , "instructor","Dr. Smith", "hamo@gmail.com" , "password");
        instructorDB.add(i); // adds to instructors.json

        // --- Courses ---
        Type courseListType = new TypeToken<ArrayList<Course>>() {}.getType();
        JsonDatabaseManager<Course> courseDB = new JsonDatabaseManager<>("courses.json", courseListType);

        Course c = new Course("C101" , "Math 101", "M101" , "I456");
//        i.add(c);
        
//        courseDB.add(c); // adds to courses.json
    }
}
