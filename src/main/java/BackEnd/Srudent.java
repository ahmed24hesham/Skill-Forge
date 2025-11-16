package BackEnd;

import static BackEnd.PasswordHasher.sha256;
import java.util.ArrayList;

public class Srudent extends User {

    private ArrayList<Integer> enrolledCourses ;
    private ArrayList<Integer> completedLessons ;

    public Srudent() {
        // Needed for Gson
    }

    public Srudent( String username, String email, String passwordHash) {
        IDGenerator idd = new IDGenerator();
        super(idd.generateUserId(), "Student",
              validateUsername(username),
              validateEmail(email),
             sha256(passwordHash));
            enrolledCourses = new ArrayList<>();
    completedLessons = new ArrayList<>();
    }

    // ----------------- Validations -----------------
    private static String validateStudentId(String id) {
        if (id != null && id.matches("S\\d+")) return id;
        return null;
    }

    private static String validateUsername(String username) {
        if (username == null) return null;
        username = username.trim();
        return username.length() >= 3 ? username : null;
    }

    private static String validateEmail(String email) {
        if (email == null) return null;
        email = email.trim();
        int atIndex = email.indexOf("@");
        if (atIndex <= 0 || atIndex == email.length() - 1) return null;
        String domain = email.substring(atIndex + 1);
        if (!domain.contains(".") || domain.startsWith(".") || domain.endsWith(".")) return null;
        return email;
    }

    // ----------------- Getters -----------------
    public ArrayList<Integer> getEnrolledCourses() {
        return enrolledCourses;
    }

    public ArrayList<Integer> getCompletedLessons() {
        return completedLessons;
    }

    // ----------------- Course Methods -----------------
    public void enrollCourse(int courseId) {
        if (courseId > 0 && !enrolledCourses.contains(courseId)) {
            enrolledCourses.add(courseId);
        }
    }

    public void completeLesson(int lessonId) {
        if (lessonId > 0 && !completedLessons.contains(lessonId)) {
            completedLessons.add(lessonId);
        }
    }
}