package BackEnd;
import java.util.List;
import java.util.ArrayList;


public class Course {
    private String courseId;
    private String title;
    private String description;
    private String instructorId;

    private ArrayList<Lesson> lessons;
    private ArrayList<String> students;  
    
    public Course(String courseId, String title, String description, String instructorId) {
        if (courseId.charAt(0)=='C' && courseId.substring(1).matches("\\d+") && courseId != null )
        {
            this.courseId = courseId;
        }else {
            courseId = null ;
        }
        
        this.title = title;
        this.description = description;
        if (instructorId.charAt(0)=='I' && instructorId.substring(1).matches("\\d+") && instructorId != null)
        {
            this.instructorId = instructorId;
        }else {
            instructorId = null;
        }
        
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
    }
    public Course() {
        this.lessons = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
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

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    
    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void removeLesson(String lessonId) {
        lessons.removeIf(l -> l.getLessonId().equals(lessonId));
    }

    public Lesson getLessonById(String lessonId) {
        for (Lesson l : lessons) {
                if (l.getLessonId().equals(lessonId))
                return l;
        }
        return null;
    }

  
    public void enrollStudent(String studentUserId) {
        if (!students.contains(studentUserId)) {
            students.add(studentUserId);
        }
    }

    public void removeStudent(String studentUserId) {
        students.removeIf(id -> id == studentUserId);
    }

    @Override
    public String toString() {
        return title;
    }


}
