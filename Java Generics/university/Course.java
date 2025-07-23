package university;
import java.util.*;
import java.time.LocalDateTime;
public class Course<T extends CourseType> {
    private String courseId;
    private String courseName;
    private String department;
    private T courseType;
    private String instructor;
    private List<String> enrolledStudents;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String schedule; 
    private String location;
    private List<String> prerequisites;
    private boolean isActive;
    public Course(String courseId, String courseName, String department, T courseType,
            String instructor, LocalDateTime startDate, LocalDateTime endDate,
            String schedule, String location) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
        this.instructor = instructor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.schedule = schedule;
        this.location = location;
        this.enrolledStudents = new ArrayList<>();
        this.prerequisites = new ArrayList<>();
        this.isActive = true;
    }
    public boolean enrollStudent(String studentId) {
        if (enrolledStudents.size() >= courseType.getMaxStudents()) {
            System.out.println("Course is full! Cannot enroll student: " + studentId);
            return false;
        }
        if (enrolledStudents.contains(studentId)) {
            System.out.println("Student " + studentId + " is already enrolled");
            return false;
        }
        enrolledStudents.add(studentId);
        System.out.println("Enrolled student " + studentId + " in course " + courseName);
        return true;
    }
    public boolean dropStudent(String studentId) {
        boolean removed = enrolledStudents.remove(studentId);
        if (removed) {
            System.out.println("Dropped student " + studentId + " from course " + courseName);
        }
        return removed;
    }
    public boolean isFull() {
        return enrolledStudents.size() >= courseType.getMaxStudents();
    }
    public int getAvailableSpots() {
        return courseType.getMaxStudents() - enrolledStudents.size();
    }
    public double getEnrollmentPercentage() {
        return (double) enrolledStudents.size() / courseType.getMaxStudents() * 100;
    }
    public void addPrerequisite(String prerequisiteCourse) {
        if (!prerequisites.contains(prerequisiteCourse)) {
            prerequisites.add(prerequisiteCourse);
        }
    }
    public boolean meetsPrerequisites(String studentId, Set<String> completedCourses) {
        return completedCourses.containsAll(prerequisites);
    }
    public String getDifficultyLevel() {
        double workload = courseType.calculateWorkload();
        if (workload < 5)
            return "Easy";
        else if (workload < 10)
            return "Moderate";
        else if (workload < 15)
            return "Hard";
        else
            return "Very Hard";
    }
    public boolean canBeOnline() {
        return courseType.isOnlineCompatible();
    }
    public String getCourseId() {
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getDepartment() {
        return department;
    }
    public T getCourseType() {
        return courseType;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public List<String> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }
    public int getEnrollementCount() {
        return enrolledStudents.size();
    }
    public LocalDateTime getStartDate() {
        return startDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public String getSchedule() {
        return schedule;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public List<String> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
    @Override
    public String toString() {
        return String.format("Course[ID: %s, Name: %s, Dept: %s, Type: %s, Instructor: %s, " +
                "Enrolled: %d/%d (%.1f%%), Schedule: %s, Location: %s, " +
                "Difficulty: %s, Online: %s, Active: %s]",
                courseId, courseName, department, courseType.getTypeName(), instructor,
                enrolledStudents.size(), courseType.getMaxStudents(), getEnrollmentPercentage(),
                schedule, location, getDifficultyLevel(), canBeOnline(), isActive);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Course<?> course = (Course<?>) obj;
        return Objects.equals(courseId, course.courseId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}