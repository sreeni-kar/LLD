import java.util.*;

public class CourseRepository {
    private static final CourseRepository instance = new CourseRepository();

    private final Map<String, Set<Integer>> courseToStudent;
    private final Map<String, Course> courseListById;
    private final Map<String, Course> courseListByName;

    private CourseRepository() {
        courseToStudent = new HashMap<>();
        courseListById = new HashMap<>();
        courseListByName = new HashMap<>();
    }

    public static CourseRepository getInstance() {
        return instance;
    }

    public void addCourse(String courseCode, String courseName, String instructor, int maxCapacity) {
        if (courseListById.containsKey(courseCode)) {
            System.out.println("Course already present in system, cannot add it again!!!");
            return;
        }

        Course course = new Course(courseCode, courseName, instructor, maxCapacity);
        courseListById.put(courseCode, course);
        courseListByName.put(courseName, course);
    }

    public Course getCourseById(String courseCode) {
        if (!courseListById.containsKey(courseCode)) {
            System.out.println("Course does not exist !!!");
            return null;
        }
        return courseListById.get(courseCode);
    }

    public Course getCourseByName(String courseName) {
        if (!courseListByName.containsKey(courseName)) {
            System.out.println("Course does not exist !!!");
            return null;
        }
        return courseListByName.get(courseName);
    }

    public List<Course> getRegisteredCourses(int studentId) {
        List<Course> courses = new ArrayList<>();
        for (String cId : courseToStudent.keySet()) {
            if (courseToStudent.get(cId).contains(studentId)) {
                courses.add(courseListById.get(cId));
            }
        }

        return courses;
    }

    public boolean isStudentRegisteredForCourse(int studentId, String courseId) {
        if (isCourseEmpty(courseId)) {
            return false;
        }
        return courseToStudent.get(courseId).contains(studentId);
    }

    public int getCurrentCapacity(String courseCode) {
        if (isCourseEmpty(courseCode)) {
            return 0;
        }
        return courseToStudent.get(courseCode).size();
    }

    synchronized public void addStudentToCourse(String courseCode, int studentId) {
        if (isCourseEmpty(courseCode)) {
            courseToStudent.put(courseCode, new HashSet<>());
        }
        courseToStudent.get(courseCode).add(studentId);
    }

    private boolean isCourseEmpty(String courseId) {
        return !courseToStudent.containsKey(courseId);
    }
}
