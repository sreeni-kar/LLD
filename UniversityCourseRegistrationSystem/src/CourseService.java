import java.util.List;

public class CourseService {
    private static final CourseService instance = new CourseService();

    private final CourseRepository courseRepository;

    private CourseService() {
        this.courseRepository = CourseRepository.getInstance();
    }

    public static CourseService getInstance() {
        return instance;
    }

    public void printRegisteredCourses(int studentId) {
        List<Course> courses = courseRepository.getRegisteredCourses(studentId);
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

    public void register(String courseCode, int studentId) {
        Course course = courseRepository.getCourseById(courseCode);
        if (course == null) {
            System.out.println("Invalid Course");
            return;
        }

        synchronized (courseCode.intern()) {
            if (courseRepository.isStudentRegisteredForCourse(studentId, courseCode)) {
                System.out.println("Already registered.");
                return;
            }

            if (courseRepository.getCurrentCapacity(courseCode) >= course.getMaxCapacity()) {
                System.out.println("Course is full.");
                return;
            }

            courseRepository.addStudentToCourse(courseCode, studentId);
            System.out.println(studentId + " registered for: " + courseCode);
        }
    }


    public Course searchCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }

    public Course searchCourseById(String courseId) {
        return courseRepository.getCourseById(courseId);
    }
}
