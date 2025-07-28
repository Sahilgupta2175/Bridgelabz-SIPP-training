import java.util.*;

class StudentMarksReport {
    private Map<String, List<Integer>> studentMarks;

    public StudentMarksReport() {
        this.studentMarks = new HashMap<>();
    }

    public void addStudent(String studentName) {
        if (!studentMarks.containsKey(studentName)) {
            studentMarks.put(studentName, new ArrayList<>());
            System.out.println("Student " + studentName + " added successfully.");
        } else {
            System.out.println("Student " + studentName + " already exists.");
        }
    }

    public void addMarks(String studentName, int... marks) {
        if (studentMarks.containsKey(studentName)) {
            List<Integer> studentMarksList = studentMarks.get(studentName);
            for (int mark : marks) {
                if (mark >= 0 && mark <= 100) {
                    studentMarksList.add(mark);
                } else {
                    System.out.println("Invalid mark: " + mark + ". Marks should be between 0 and 100.");
                }
            }
            System.out.println("Marks added for " + studentName);
        } else {
            System.out.println("Student " + studentName + " not found. Please add the student first.");
        }
    }

    public double calculateAverage(String studentName) {
        if (studentMarks.containsKey(studentName)) {
            List<Integer> marks = studentMarks.get(studentName);
            if (marks.isEmpty()) {
                return 0.0;
            }
            int sum = marks.stream().mapToInt(Integer::intValue).sum();
            return (double) sum / marks.size();
        } else {
            System.out.println("Student " + studentName + " not found.");
            return 0.0;
        }
    }

    public String getTopPerformingStudent() {
        if (studentMarks.isEmpty()) {
            return "No students found";
        }

        String topStudent = null;
        double highestAverage = -1;

        for (String student : studentMarks.keySet()) {
            double average = calculateAverage(student);
            if (average > highestAverage) {
                highestAverage = average;
                topStudent = student;
            }
        }

        return topStudent;
    }

    public void displayStudentReport(String studentName) {
        if (studentMarks.containsKey(studentName)) {
            List<Integer> marks = studentMarks.get(studentName);
            double average = calculateAverage(studentName);
            String grade = assignGrade(average);

            System.out.println("\n===== STUDENT REPORT =====");
            System.out.println("Student Name: " + studentName);
            System.out.println("Marks: " + marks);
            System.out.printf("Average: %.2f\n", average);
            System.out.println("Grade: " + grade);
            System.out.println("==========================");
        } else {
            System.out.println("Student " + studentName + " not found.");
        }
    }

    public void displayAllStudents() {
        if (studentMarks.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n===== ALL STUDENTS REPORT =====");
        for (String student : studentMarks.keySet()) {
            double average = calculateAverage(student);
            System.out.printf("%-15s | Average: %.2f | Grade: %s\n",
                    student, average, assignGrade(average));
        }
        System.out.println("===============================");
    }

    private String assignGrade(double average) {
        if (average >= 90)
            return "A+";
        if (average >= 80)
            return "A";
        if (average >= 70)
            return "B+";
        if (average >= 60)
            return "B";
        if (average >= 50)
            return "C";
        if (average >= 40)
            return "D";
        return "F";
    }

    public void showMenu() {
        System.out.println("\n===== STUDENT MARKS REPORT SYSTEM =====");
        System.out.println("1. Add Student");
        System.out.println("2. Add Marks to Student");
        System.out.println("3. Calculate Student Average");
        System.out.println("4. Get Top Performing Student");
        System.out.println("5. Display Student Report");
        System.out.println("6. Display All Students");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }
}

public class StudentMarksAnalyzer {
    public static void main(String[] args) {
        StudentMarksReport report = new StudentMarksReport();
        Scanner scanner = new Scanner(System.in);

        report.addStudent("Alice");
        report.addStudent("Bob");
        report.addStudent("Charlie");
        report.addStudent("Diana");

        report.addMarks("Alice", 85, 92, 78, 90);
        report.addMarks("Bob", 72, 85, 88, 76);
        report.addMarks("Charlie", 95, 89, 92, 97);
        report.addMarks("Diana", 68, 74, 82, 70);

        while (true) {
            report.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    report.addStudent(name);
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter marks (space-separated): ");
                    String marksInput = scanner.nextLine();
                    String[] marksStr = marksInput.split("\\s+");
                    int[] marks = new int[marksStr.length];
                    for (int i = 0; i < marksStr.length; i++) {
                        marks[i] = Integer.parseInt(marksStr[i]);
                    }
                    report.addMarks(studentName, marks);
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    String avgStudent = scanner.nextLine();
                    double average = report.calculateAverage(avgStudent);
                    System.out.printf("Average marks for %s: %.2f\n", avgStudent, average);
                    break;

                case 4:
                    String topStudent = report.getTopPerformingStudent();
                    double topAverage = report.calculateAverage(topStudent);
                    System.out.printf("Top performing student: %s with average %.2f\n",
                            topStudent, topAverage);
                    break;

                case 5:
                    System.out.print("Enter student name: ");
                    String reportStudent = scanner.nextLine();
                    report.displayStudentReport(reportStudent);
                    break;

                case 6:
                    report.displayAllStudents();
                    break;

                case 7:
                    System.out.println("Thank you for using Student Marks Report System!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
