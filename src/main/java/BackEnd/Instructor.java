package BackEnd;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Instructor extends User{

    public Instructor(String userId, String role, String username, String email, String passwordHash) {
        super(userId, role, username, email, passwordHash);
        
    }
       Type courseListType = new TypeToken<ArrayList<Course>>() {}.getType();
    JsonDatabaseManager<Course> courseDB = new JsonDatabaseManager<>("courses.json", courseListType);
    public void createCourse (Course c ){
        if(c!=null&&c.getCourseId()!=null)
        courseDB.add(c);
        else 
            System.out.println("Invalid course");
    }
    public void viewEnrolledStudents(String cID){
    ArrayList<Course> list=courseDB.load();
    for(int i=0;i<list.size();i++){
         if(list.get(i).getCourseId().equals(cID)){
         ArrayList<String>st=list.get(i).getStudents();
         System.out.println("Enrolled students in this course are:");
         for(int j=0;j<st.size();j++)
             System.out.println(st.get(j));
         return;
         }
         }
    }
    public void addLesson(String cID,Lesson l){
         ArrayList<Course> list=courseDB.load();
         for(int i=0;i<list.size();i++){
         if(list.get(i).getCourseId().equals(cID)&&l!=null&&l.getLessonId()!=null)
             list.get(i).addLesson(l);
         }
          courseDB.save(list);
    }
       public void deleteLesson(String cID,Lesson l){
         ArrayList<Course> list=courseDB.load();
         for(int i=0;i<list.size();i++){
         if(list.get(i).getCourseId().equals(cID)&&l!=null&&l.getLessonId()!=null)
             list.get(i).removeLesson(l.getLessonId());
         }
         courseDB.save(list);
    }
       public void editLesson(String cID, String lID, String newTitle, String newContent, String newLessonId) {
    ArrayList<Course> list = courseDB.load();
    for (Course c : list) {
        if (c.getCourseId().equals(cID)) {
            ArrayList<Lesson> lessons = c.getLessons();
            for (Lesson l : lessons) {
                if (l.getLessonId().equals(lID)) {
                    if (newTitle != null && !newTitle.trim().isEmpty()) {
                        l.setTitle(newTitle);
                    }
                    if (newContent != null) {
                        l.setContent(newContent);
                    }
                    if (newLessonId != null && 
                        !newLessonId.trim().isEmpty() &&
                        newLessonId.charAt(0) == 'L' && 
                        newLessonId.substring(1).matches("\\d+")) {

                        l.setLessonId(newLessonId);

                    } else {
                        System.out.println("Wrong ID. Lesson ID will remain unchanged.");
                    }
                }
            }
        }
    }
    courseDB.save(list);
}

}   