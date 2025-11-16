package BackEnd;

public class IDGenerator {

    private static int lastCourseId = 100;      // C101 starts at 101
    private static int lastUserId = 100;     // U101
    private static int lastLessonId = 100;      // L101

    public static String generateCourseId() {
        lastCourseId++;
        return "C" + lastCourseId;
    }

  

    public static String generateUserId() {
        lastUserId++;
        return "U" + lastUserId;
    }

    public static String generateLessonId() {
        lastLessonId++;
        return "L" + lastLessonId;
    }

}
