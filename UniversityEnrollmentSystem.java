import java.util.*;

interface Graded {
    void assignGrade(Enrollment enrollment, Object gradeValue);
}

abstract class Student {
    private String name;
    private int id;
    private List<Enrollment> enrollments = new ArrayList<>();
    private double gpa = 0.0;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Student(String name, int id, List<String> electivePreferences) {
        this(name, id);
    }

    public void enroll(Course course) {
        Enrollment e = new Enrollment(this, course);
        enrollments.add(e);
        course.addEnrollment(e);
    }

    public void updateGPA() {
        double total = 0;
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getGrade() != null && e.getGrade() instanceof Double) {
                total += (Double) e.getGrade();
                count++;
            }
        }
        if (count > 0)
            this.gpa = total / count;
    }

    public double getGPA() {
        return gpa;
    }

    public String getTranscript() {
        StringBuilder sb = new StringBuilder();
        sb.append("Transcript for ").append(name).append(":\n");
        for (Enrollment e : enrollments) {
            sb.append(e.getCourse().getTitle()).append(": ").append(e.getGrade()).append("\n");
        }
        sb.append("GPA: ").append(gpa);
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}

class Undergraduate extends Student {
    public Undergraduate(String name, int id) {
        super(name, id);
    }

    public Undergraduate(String name, int id, List<String> electives) {
        super(name, id, electives);
    }
}

class Postgraduate extends Student {
    public Postgraduate(String name, int id) {
        super(name, id);
    }

    public Postgraduate(String name, int id, List<String> electives) {
        super(name, id, electives);
    }
}

class Course {
    private String code;
    private String title;
    private List<Enrollment> enrollments = new ArrayList<>();

    public Course(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public void addEnrollment(Enrollment e) {
        enrollments.add(e);
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }
}

class Faculty implements Graded {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void assignGrade(Enrollment enrollment, Object gradeValue) {
        enrollment.setGrade(gradeValue);
        enrollment.getStudent().updateGPA();
    }

    public String getName() {
        return name;
    }
}

class Enrollment {
    private Student student;
    private Course course;
    private Object grade;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void setGrade(Object grade) {
        this.grade = grade;
    }

    public Object getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}

public class UniversityEnrollmentSystem {
    public static void main(String[] args) {
        Undergraduate u1 = new Undergraduate("Alice", 1);
        Postgraduate p1 = new Postgraduate("Bob", 2, Arrays.asList("AI", "ML"));

        Course c1 = new Course("CS101", "Intro to CS");
        Course c2 = new Course("CS201", "Advanced AI");

        u1.enroll(c1);
        p1.enroll(c1);
        p1.enroll(c2);

        Faculty f1 = new Faculty("Dr. Smith");

        for (Student s : Arrays.asList(u1, p1)) {
            for (Enrollment en : s.getEnrollments()) {
                if (en.getStudent() instanceof Undergraduate) {
                    f1.assignGrade(en, 3.7);
                } else {
                    f1.assignGrade(en, "A");
                }
            }
        }

        System.out.println(u1.getTranscript());
        System.out.println(p1.getTranscript());
    }
}
