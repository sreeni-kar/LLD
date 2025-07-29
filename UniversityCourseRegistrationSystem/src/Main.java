public class Main {
    public static void main(String[] args) {
        CourseService courseService = CourseService.getInstance();
        CourseRepository courseRepo = CourseRepository.getInstance();

        // Add test courses
        courseRepo.addCourse("CS101", "Data Structures", "Prof. Smith", 2);
        courseRepo.addCourse("CS102", "Algorithms", "Prof. Jane", 3);

        System.out.println("== Course Search Test ==");
        Course byName = courseService.searchCourseByName("Data Structures");
        System.out.println("Search by name: " + (byName != null ? byName : "Not found"));

        Course byId = courseService.searchCourseById("CS102");
        System.out.println("Search by ID: " + (byId != null ? byId : "Not found"));

        System.out.println("\n== Registering with Threads ==");
        // 5 threads trying to register for CS101 which has capacity = 2
        for (int i = 1; i <= 5; i++) {
            int studentId = i;
            new Thread(() -> {
                courseService.register("CS101", studentId);
                courseService.printRegisteredCourses(studentId);
            }).start();
        }

        // Wait for above threads to complete
        try {
            Thread.sleep(2000); // crude wait for demo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n== Duplicate Registration Test ==");
        courseService.register("CS102", 100);
        courseService.register("CS102", 100); // should show already registered

        System.out.println("\n== Course Full Test ==");
        courseService.register("CS101", 6); // should show full, already at capacity

        System.out.println("\n== Final Registered Courses ==");
        for (int studentId = 1; studentId <= 6; studentId++) {
            System.out.println("Student ID " + studentId + " registered for:");
            courseService.printRegisteredCourses(studentId);
        }
    }
}
