import java.util.Scanner;

class StudentData {
    String name;
    int[] marks;
    String[] subjects;

    public StudentData(String name, int[] marks, String[] subjects) {
        this.name = name;
        this.marks = marks;
        this.subjects = subjects;
    }

    public double calculateAverage(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        return (double) totalMarks / marks.length;
    }

    public String gradeAssign(double average) {
        if (average >= 90.00) {
            return "A+";
        } else if (average >= 80.00) {
            return "A";
        } else if (average >= 70.00) {
            return "B+";
        } else if (average >= 60.00) {
            return "B";
        } else if (average >= 50.00) {
            return "C";
        } else if (average >= 40.00) {
            return "D";
        } else {
            return "F";
        }
    }

    public void displayReportCard(String name, String[] subjects, int[] marks) {
        double average = calculateAverage(marks);
        String grade = gradeAssign(average);

        System.out.println("\n===== STUDENT REPORT CARD =====");
        System.out.println("Student Name: " + name);

        System.out.println("\n+-----------------+-------+");
        System.out.println("| Subject         | Marks |");
        System.out.println("+-----------------+-------+");

        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("| %-15s | %-5d |\n", subjects[i], marks[i]);
        }

        System.out.println("+-----------------+-------+");
        System.out.printf("| Average         | %-5.2f |\n", average);
        System.out.printf("| Grade           | %-5s |\n", grade);
        System.out.println("+-----------------+-------+");
    }
}

public class StudentReportCard {
    public static void main(String[] args) {
        System.out.println("Enter Total Students : ");
        Scanner sc = new Scanner(System.in);
        int totalStudents = sc.nextInt();
        sc.nextLine();

        StudentData[] student = new StudentData[totalStudents];
        for (int i = 0; i < student.length; i++) {
            System.out.println("Enter Student Name:");
            String name = sc.nextLine();

            System.out.println("Enter Number of Subjects:");
            int numSubjects = sc.nextInt();

            sc.nextLine();

            String[] subjects = new String[numSubjects];
            int[] marks = new int[numSubjects];

            for (int j = 0; j < numSubjects; j++) {
                System.out.println("Enter Subject name " + (j + 1) + ":");
                subjects[j] = sc.nextLine();

                System.out.println("Enter Marks for " + subjects[j] + ":");
                marks[j] = sc.nextInt();
                sc.nextLine();
            }

            StudentData studentData1 = new StudentData(name, marks, subjects);
            studentData1.displayReportCard(name, subjects, marks);
        }
        sc.close();
    }
}
