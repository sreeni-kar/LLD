public class Course {
    private final String courseCode;
    private final String courseName;
    private final String instructor;
    private final int maxCapacity;

    public Course(String courseCode, String courseName, String instructor, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.maxCapacity = maxCapacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                ", maxCapacity=" + maxCapacity +
                '}';
    }
}
