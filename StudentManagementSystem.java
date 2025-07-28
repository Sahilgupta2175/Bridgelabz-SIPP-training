import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private Set<String> subjects;
    private Map<String, Double> grades;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subjects = new HashSet<>();
        this.grades = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getSubjects() {
        return subjects;
    }

    public Map<String, Double> getGrades() {
        return grades;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void addGrade(String subject, double grade) {
        if (subjects.contains(subject)) {
            grades.put(subject, grade);
        } else {
            System.out.println("Student is not enrolled in " + subject);
        }
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        return grades.values().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Age: %d, Subjects: %s, Average Grade: %.2f",
                id, name, age, subjects, getAverageGrade());
    }
}

class StudentManagementSystem {
    private Map<Integer, Student> studentsById;
    private Map<String, Student> studentsByName;

    public StudentManagementSystem() {
        this.studentsById = new HashMap<>();
        this.studentsByName = new HashMap<>();
    }

    public void addStudent(int id, String name, int age) {
        if (studentsById.containsKey(id)) {
            System.out.println("Student with ID " + id + " already exists.");
            return;
        }
        if (studentsByName.containsKey(name.toLowerCase())) {
            System.out.println("Student with name " + name + " already exists.");
            return;
        }

        Student student = new Student(id, name, age);
        studentsById.put(id, student);
        studentsByName.put(name.toLowerCase(), student);
        System.out.println("Student " + name + " added successfully.");
    }

    public boolean removeStudentById(int id) {
        Student student = studentsById.remove(id);
        if (student != null) {
            studentsByName.remove(student.getName().toLowerCase());
            System.out.println("Student with ID " + id + " removed successfully.");
            return true;
        } else {
            System.out.println("Student with ID " + id + " not found.");
            return false;
        }
    }

    public boolean removeStudentByName(String name) {
        Student student = studentsByName.remove(name.toLowerCase());
        if (student != null) {
            studentsById.remove(student.getId());
            System.out.println("Student " + name + " removed successfully.");
            return true;
        } else {
            System.out.println("Student with name " + name + " not found.");
            return false;
        }
    }

    public Student searchStudentById(int id) {
        return studentsById.get(id);
    }

    public Student searchStudentByName(String name) {
        return studentsByName.get(name.toLowerCase());
    }

    public void enrollStudentInSubject(int studentId, String subject) {
        Student student = searchStudentById(studentId);
        if (student != null) {
            student.addSubject(subject);
            System.out.println("Student " + student.getName() + " enrolled in " + subject);
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public void addGradeToStudent(int studentId, String subject, double grade) {
        Student student = searchStudentById(studentId);
        if (student != null) {
            if (grade >= 0 && grade <= 100) {
                student.addGrade(subject, grade);
                System.out.println("Grade " + grade + " added for " + student.getName() + " in " + subject);
            } else {
                System.out.println("Invalid grade. Grade should be between 0 and 100.");
            }
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }

    public List<Student> sortStudentsByName() {
        List<Student> students = new ArrayList<>(studentsById.values());
        students.sort(Comparator.comparing(Student::getName));
        return students;
    }

    public List<Student> sortStudentsByGrade() {
        List<Student> students = new ArrayList<>(studentsById.values());
        students.sort(Comparator.comparingDouble(Student::getAverageGrade).reversed());
        return students;
    }

    public Set<Student> findStudentsInSubject(String subject) {
        Set<Student> studentsInSubject = new HashSet<>();
        for (Student student : studentsById.values()) {
            if (student.getSubjects().contains(subject)) {
                studentsInSubject.add(student);
            }
        }
        return studentsInSubject;
    }

    public void displayAllStudents() {
        if (studentsById.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.println("\n===== ALL STUDENTS =====");
        for (Student student : studentsById.values()) {
            System.out.println(student);
        }
        System.out.println("========================");
    }

    public void displayStudentsSortedByName() {
        List<Student> sortedStudents = sortStudentsByName();
        System.out.println("\n===== STUDENTS SORTED BY NAME =====");
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
        System.out.println("===================================");
    }

    public void displayStudentsSortedByGrade() {
        List<Student> sortedStudents = sortStudentsByGrade();
        System.out.println("\n===== STUDENTS SORTED BY GRADE =====");
        for (Student student : sortedStudents) {
            System.out.println(student);
        }
        System.out.println("====================================");
    }

    public void displayStudentsInSubject(String subject) {
        Set<Student> studentsInSubject = findStudentsInSubject(subject);
        System.out.println("\n===== STUDENTS IN " + subject.toUpperCase() + " =====");
        if (studentsInSubject.isEmpty()) {
            System.out.println("No students enrolled in " + subject);
        } else {
            for (Student student : studentsInSubject) {
                System.out.println(student);
            }
        }
        System.out.println("===============================");
    }

    public void showMenu() {
        System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student by ID");
        System.out.println("3. Remove Student by Name");
        System.out.println("4. Search Student by ID");
        System.out.println("5. Search Student by Name");
        System.out.println("6. Enroll Student in Subject");
        System.out.println("7. Add Grade to Student");
        System.out.println("8. Display All Students");
        System.out.println("9. Display Students Sorted by Name");
        System.out.println("10. Display Students Sorted by Grade");
        System.out.println("11. Find Students in Subject");
        System.out.println("12. Exit");
        System.out.print("Choose an option: ");
    }
}

class StudentManagementApp {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        sms.addStudent(101, "Alice Johnson", 20);
        sms.addStudent(102, "Bob Smith", 21);
        sms.addStudent(103, "Charlie Brown", 19);
        sms.addStudent(104, "Diana Prince", 22);
        sms.addStudent(105, "Eve Wilson", 20);

        sms.enrollStudentInSubject(101, "Mathematics");
        sms.enrollStudentInSubject(101, "Physics");
        sms.enrollStudentInSubject(102, "Mathematics");
        sms.enrollStudentInSubject(102, "Chemistry");
        sms.enrollStudentInSubject(103, "Physics");
        sms.enrollStudentInSubject(103, "Chemistry");
        sms.enrollStudentInSubject(104, "Mathematics");
        sms.enrollStudentInSubject(104, "Physics");
        sms.enrollStudentInSubject(105, "Chemistry");

        sms.addGradeToStudent(101, "Mathematics", 92.5);
        sms.addGradeToStudent(101, "Physics", 88.0);
        sms.addGradeToStudent(102, "Mathematics", 85.5);
        sms.addGradeToStudent(102, "Chemistry", 90.0);
        sms.addGradeToStudent(103, "Physics", 78.5);
        sms.addGradeToStudent(103, "Chemistry", 82.0);
        sms.addGradeToStudent(104, "Mathematics", 95.0);
        sms.addGradeToStudent(104, "Physics", 91.5);
        sms.addGradeToStudent(105, "Chemistry", 87.0);

        while (true) {
            sms.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    sms.addStudent(id, name, age);
                    break;

                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    sms.removeStudentById(removeId);
                    break;

                case 3:
                    System.out.print("Enter student name to remove: ");
                    String removeName = scanner.nextLine();
                    sms.removeStudentByName(removeName);
                    break;

                case 4:
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine();
                    Student foundById = sms.searchStudentById(searchId);
                    if (foundById != null) {
                        System.out.println("Student found: " + foundById);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter student name to search: ");
                    String searchName = scanner.nextLine();
                    Student foundByName = sms.searchStudentByName(searchName);
                    if (foundByName != null) {
                        System.out.println("Student found: " + foundByName);
                    } else {
                        System.out.println("Student with name " + searchName + " not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter student ID: ");
                    int enrollId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter subject name: ");
                    String subject = scanner.nextLine();
                    sms.enrollStudentInSubject(enrollId, subject);
                    break;

                case 7:
                    System.out.print("Enter student ID: ");
                    int gradeId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter subject name: ");
                    String gradeSubject = scanner.nextLine();
                    System.out.print("Enter grade (0-100): ");
                    double grade = scanner.nextDouble();
                    scanner.nextLine();
                    sms.addGradeToStudent(gradeId, gradeSubject, grade);
                    break;

                case 8:
                    sms.displayAllStudents();
                    break;

                case 9:
                    sms.displayStudentsSortedByName();
                    break;

                case 10:
                    sms.displayStudentsSortedByGrade();
                    break;

                case 11:
                    System.out.print("Enter subject name: ");
                    String findSubject = scanner.nextLine();
                    sms.displayStudentsInSubject(findSubject);
                    break;

                case 12:
                    System.out.println("Thank you for using Student Management System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
