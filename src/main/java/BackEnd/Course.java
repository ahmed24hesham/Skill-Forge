package BackEnd;
import java.util.List;
import java.util.ArrayList;


public class Course {
    private int courseId;
    private String title;
    private String description;
    private int instructorId;

    private ArrayList<Lesson> lessons;
    private ArrayList<Integer> students;  
    
    public Course(int courseId, String title, String description, int instructorId) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.instructorId = instructorId;
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public Course() {
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public ArrayList<Integer> getStudents() {
        return students;
    }

    
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(int lessonId) {
        lessons.removeIf(l -> l.getLessonId() == lessonId);
    }

    public Lesson getLessonById(int lessonId) {
        for (Lesson l : lessons) {
            if (l.getLessonId() == lessonId)
                return l;
        }
        return null;
    }

  
    public void enrollStudent(int studentUserId) {
        if (!students.contains(studentUserId)) {
            students.add(studentUserId);
        }
    }

    public void removeStudent(int studentUserId) {
        students.removeIf(id -> id == studentUserId);
    }

    @Override
    public String toString() {
        return title;
    }


}
