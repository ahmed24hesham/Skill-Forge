package BackEnd;
import java.util.ArrayList;
public class Srudent extends User {
    private ArrayList<Integer> enrolledCourses = new ArrayList<>();
    private ArrayList<Integer> completedLessons = new ArrayList<>();
    public Srudent(String userId,String role, String username, String email, String passwordHash) {
        super(userId, "Student", validateUsername(username), validateEmail(email), passwordHash);
    }
    private static String validateUsername(String username) {
        if (username == null || username.trim().isEmpty())
            username=null;
        if (username.length() < 3)
           username=null;
        return username.trim();
    }

    private static String validateEmail(String email) {
        if (email == null || email.trim().isEmpty())
            email=null;
        if (!email.contains("@"))
             email=null;
        int atIndex = email.indexOf("@");
        if (atIndex == 0)
            email=null;
        if (atIndex == email.length() - 1)
            email=null;
        String domain = email.substring(atIndex + 1);
        if (!domain.contains("."))
              email=null;
        if (domain.startsWith(".") || domain.endsWith("."))
             email=null;

        return email;
    }

    public ArrayList<Integer> getEnrolledCourses() {
        return enrolledCourses;
    }

    public ArrayList<Integer> getCompletedLessons() {
        return completedLessons;
    }

    public void enrollCourse(int courseId) {
        if (courseId <= 0)
            System.out.println("CourseId invalid");
        else if (enrolledCourses.contains(courseId))
             System.out.println("Course already exist");
        
        else enrolledCourses.add(courseId);
    }

    public void completeLesson(int lessonId) {
        if (lessonId <= 0)
           System.out.println("Invalid lesson ID.");
        else if (completedLessons.contains(lessonId))
       System.out.println("Lesson already completed.");
        else completedLessons.add(lessonId);
    }

    public int getCourseProgress(Course course) {
        if (course == null){
           System.out.println("Course cannot be null.");
           return 0;
                   }
        
        int total = course.getLessons().size();
        if (total == 0) return 0;
        int completed = 0;
        for (Lesson l : course.getLessons()) {
            if (completedLessons.contains(l.getLessonId())) completed++;
        }
        return (completed * 100) / total;
    }
}




