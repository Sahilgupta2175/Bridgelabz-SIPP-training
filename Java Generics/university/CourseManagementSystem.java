package university;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
public class CourseManagementSystem {
    private Map<String, Course<? extends CourseType>> courses;
    private Map<String, Set<String>> studentCompletedCourses;
    private String universityName;
    public CourseManagementSystem(String universityName) {
        this.universityName = universityName;
        this.courses = new HashMap<>();
        this.studentCompletedCourses = new HashMap<>();
    }
    public <T extends CourseType> boolean addCourse(Course<T> course) {
        if (courses.containsKey(course.getCourseId())) {
            System.out.println("Course with ID " + course.getCourseId() + " already exists!");
            return false;
        }
        courses.put(course.getCourseId(), course);
        System.out.println("Added course: " + course.getCourseName());
        return true;
    }
    public void displayAllCourses() {
        System.out.println("\n=== ALL COURSES AT " + universityName.toUpperCase() + " ===");
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        Map<String, List<Course<? extends CourseType>>> coursesByDept = courses.values().stream()
                .collect(Collectors.groupingBy(Course::getDepartment));
        coursesByDept.forEach((dept, courseList) -> {
            System.out.println("\n--- " + dept.toUpperCase() + " DEPARTMENT ---");
            courseList.forEach(course -> System.out.println("  " + course));
        });
    }
    public void displayCoursesByType(String typeName) {
        System.out.println("\n=== " + typeName.toUpperCase() + " COURSES ===");
        List<Course<? extends CourseType>> filteredCourses = courses.values().stream()
                .filter(course -> course.getCourseType().getTypeName().equalsIgnoreCase(typeName))
                .collect(Collectors.toList());
        if (filteredCourses.isEmpty()) {
            System.out.println("No courses found of type: " + typeName);
        } else {
            filteredCourses.forEach(course -> System.out.println("  " + course));
        }
    }
    public <T extends CourseType> List<Course<T>> findCoursesByDifficulty(
            String difficultyLevel, Class<T> courseTypeClass) {
        List<Course<T>> result = new ArrayList<>();
        for (Course<? extends CourseType> course : courses.values()) {
            if (course.getDifficultyLevel().equalsIgnoreCase(difficultyLevel) &&
                    courseTypeClass.isInstance(course.getCourseType())) {
                @SuppressWarnings("unchecked")
                Course<T> typedCourse = (Course<T>) course;
                result.add(typedCourse);
            }
        }
        return result;
    }
    public List<Course<? extends CourseType>> findOnlineCourses() {
        return courses.values().stream()
                .filter(Course::canBeOnline)
                .collect(Collectors.toList());
    }
    public List<Course<? extends CourseType>> findCoursesWithSpots() {
        return courses.values().stream()
                .filter(course -> !course.isFull())
                .sorted((c1, c2) -> Integer.compare(c2.getAvailableSpots(), c1.getAvailableSpots()))
                .collect(Collectors.toList());
    }
    public double calculateTotalWorkload(List<? extends Course<? extends CourseType>> courseList) {
        return courseList.stream()
                .mapToDouble(course -> course.getCourseType().calculateWorkload())
                .sum();
    }
    public List<Course<? extends CourseType>> findCoursesByInstructor(String instructor) {
        return courses.values().stream()
                .filter(course -> course.getInstructor().equalsIgnoreCase(instructor))
                .collect(Collectors.toList());
    }
    public List<Course<? extends CourseType>> getCoursesByDepartment(String department) {
        return courses.values().stream()
                .filter(course -> course.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }
    public <T extends CourseType> boolean enrollStudentWithPrereqCheck(
            String courseId, String studentId) {
        Course<? extends CourseType> course = courses.get(courseId);
        if (course == null) {
            System.out.println("Course not found: " + courseId);
            return false;
        }
        Set<String> completedCourses = studentCompletedCourses.getOrDefault(studentId, new HashSet<>());
        if (!course.meetsPrerequisites(studentId, completedCourses)) {
            System.out.println("Student " + studentId + " does not meet prerequisites for " +
                    course.getCourseName());
            System.out.println("Required: " + course.getPrerequisites());
            System.out.println("Completed: " + completedCourses);
            return false;
        }
        return course.enrollStudent(studentId);
    }
    public void markCourseCompleted(String studentId, String courseId) {
        studentCompletedCourses.computeIfAbsent(studentId, k -> new HashSet<>()).add(courseId);
        System.out.println("Marked course " + courseId + " as completed for student " + studentId);
    }
    public void displaySystemStatistics() {
        System.out.println("\n=== COURSE MANAGEMENT SYSTEM STATISTICS ===");
        System.out.println("University: " + universityName);
        System.out.println("Total Courses: " + courses.size());
        Map<String, Long> typeCount = courses.values().stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCourseType().getTypeName(),
                        Collectors.counting()));
        System.out.println("\nCourses by Type:");
        typeCount.forEach((type, count) -> System.out.println("  " + type + ": " + count));
        Map<String, Long> deptCount = courses.values().stream()
                .collect(Collectors.groupingBy(
                        Course::getDepartment,
                        Collectors.counting()));
        System.out.println("\nCourses by Department:");
        deptCount.forEach((dept, count) -> System.out.println("  " + dept + ": " + count));
        int totalEnrollment = courses.values().stream()
                .mapToInt(Course::getEnrollementCount)
                .sum();
        System.out.println("\nTotal Student Enrollments: " + totalEnrollment);
        long onlineCourses = courses.values().stream()
                .filter(Course::canBeOnline)
                .count();
        System.out.println("Online-Compatible Courses: " + onlineCourses + "/" + courses.size());
        double avgWorkload = courses.values().stream()
                .mapToDouble(course -> course.getCourseType().calculateWorkload())
                .average()
                .orElse(0.0);
        System.out.println("Average Course Workload: " + String.format("%.1f", avgWorkload) + " hrs/week");
    }
    public List<Course<? extends CourseType>> recommendCourses(String studentId, String preferredDifficulty) {
        Set<String> completedCourses = studentCompletedCourses.getOrDefault(studentId, new HashSet<>());
        return courses.values().stream()
                .filter(course -> course.isActive())
                .filter(course -> !course.isFull())
                .filter(course -> course.meetsPrerequisites(studentId, completedCourses))
                .filter(course -> course.getDifficultyLevel().equalsIgnoreCase(preferredDifficulty))
                .limit(5) 
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem("Tech University");
        ExamCourse examType = new ExamCourse(30, 3.0, 3, true, 70.0);
        AssignmentCourse assignmentType = new AssignmentCourse(25, 3.0, 8, true, "digital");
        ResearchCourse researchType = new ResearchCourse(10, 4.0, "Machine Learning", true, 2, "professor");
        Course<ExamCourse> mathCourse = new Course<>(
                "MATH101", "Calculus I", "Mathematics", examType,
                "Dr. Smith", LocalDateTime.now().plusDays(30), LocalDateTime.now().plusDays(120),
                "MWF 09:00-10:00", "Room 201");
        Course<AssignmentCourse> csCourse = new Course<>(
                "CS201", "Data Structures", "Computer Science", assignmentType,
                "Prof. Johnson", LocalDateTime.now().plusDays(30), LocalDateTime.now().plusDays(120),
                "TTh 14:00-15:30", "Lab A");
        Course<ResearchCourse> aiCourse = new Course<>(
                "CS501", "Advanced AI Research", "Computer Science", researchType,
                "Dr. Williams", LocalDateTime.now().plusDays(30), LocalDateTime.now().plusDays(150),
                "By Appointment", "Research Lab");
        ExamCourse examType2 = new ExamCourse(40, 4.0, 2, false, 60.0);
        Course<ExamCourse> physicsCourse = new Course<>(
                "PHYS101", "General Physics", "Physics", examType2,
                "Dr. Brown", LocalDateTime.now().plusDays(30), LocalDateTime.now().plusDays(120),
                "MWF 11:00-12:00", "Room 301");
        AssignmentCourse assignmentType2 = new AssignmentCourse(20, 3.0, 6, false, "both");
        Course<AssignmentCourse> webDevCourse = new Course<>(
                "CS301", "Web Development", "Computer Science", assignmentType2,
                "Ms. Davis", LocalDateTime.now().plusDays(30), LocalDateTime.now().plusDays(120),
                "TTh 10:00-11:30", "Computer Lab");
        cms.addCourse(mathCourse);
        cms.addCourse(csCourse);
        cms.addCourse(aiCourse);
        cms.addCourse(physicsCourse);
        cms.addCourse(webDevCourse);
        csCourse.addPrerequisite("MATH101");
        aiCourse.addPrerequisite("CS201");
        webDevCourse.addPrerequisite("CS201");
        System.out.println("=== COURSE MANAGEMENT SYSTEM DEMO ===");
        String[] students = { "STU001", "STU002", "STU003", "STU004", "STU005" };
        for (String student : students) {
            mathCourse.enrollStudent(student);
            physicsCourse.enrollStudent(student);
        }
        cms.markCourseCompleted("STU001", "MATH101");
        cms.markCourseCompleted("STU002", "MATH101");
        cms.markCourseCompleted("STU003", "MATH101");
        System.out.println("\n=== TESTING PREREQUISITE SYSTEM ===");
        cms.enrollStudentWithPrereqCheck("CS201", "STU001"); 
        cms.enrollStudentWithPrereqCheck("CS201", "STU004"); 
        cms.markCourseCompleted("STU001", "CS201");
        cms.enrollStudentWithPrereqCheck("CS301", "STU001"); 
        cms.enrollStudentWithPrereqCheck("CS501", "STU001"); 
        cms.displayAllCourses();
        cms.displayCoursesByType("Exam-Based");
        cms.displayCoursesByType("Assignment-Based");
        cms.displayCoursesByType("Research-Based");
        System.out.println("\n=== ONLINE-COMPATIBLE COURSES ===");
        cms.findOnlineCourses().forEach(course -> System.out
                .println("  " + course.getCourseName() + " - " + course.getCourseType().getTypeName()));
        System.out.println("\n=== COURSES WITH AVAILABLE SPOTS ===");
        cms.findCoursesWithSpots().forEach(course -> System.out
                .println("  " + course.getCourseName() + " - " + course.getAvailableSpots() + " spots available"));
        System.out.println("\n=== COURSES BY DR. SMITH ===");
        cms.findCoursesByInstructor("Dr. Smith").forEach(course -> System.out.println("  " + course.getCourseName()));
        System.out.println("\n=== COURSE RECOMMENDATIONS FOR STU001 (MODERATE DIFFICULTY) ===");
        cms.recommendCourses("STU001", "Moderate").forEach(
                course -> System.out.println("  " + course.getCourseName() + " - " + course.getDifficultyLevel()));
        List<Course<? extends CourseType>> csCourses = cms.getCoursesByDepartment("Computer Science");
        double totalWorkload = cms.calculateTotalWorkload(csCourses);
        System.out.println("\n=== COMPUTER SCIENCE DEPARTMENT WORKLOAD ===");
        System.out.println("Total workload for CS courses: " + String.format("%.1f", totalWorkload) + " hrs/week");
        cms.displaySystemStatistics();
        System.out.println("\n=== HARD EXAM COURSES ===");
        List<Course<ExamCourse>> hardExamCourses = cms.findCoursesByDifficulty("Hard", ExamCourse.class);
        hardExamCourses.forEach(course -> System.out.println("  " + course.getCourseName() + " - Workload: " +
                course.getCourseType().calculateWorkload() + " hrs/week"));
    }
}