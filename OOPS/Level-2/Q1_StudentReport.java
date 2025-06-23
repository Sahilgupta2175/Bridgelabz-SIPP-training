public class Q1_StudentReport {

    static class Student {
        String name;
        int rollNumber;
        double marks;

        public Student(String name, int rollNumber, double marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        public char calculateGrade() {
            if (marks >= 90) return 'A';
            else if (marks >= 75) return 'B';
            else if (marks >= 60) return 'C';
            else if (marks >= 40) return 'D';
            else return 'F';
        }

        public void displayDetails() {
            System.out.println("Name      : " + name);
            System.out.println("Roll No   : " + rollNumber);
            System.out.println("Marks     : " + marks);
            System.out.println("Grade     : " + calculateGrade());
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Riya Sharma", 101, 87.5);
        s1.displayDetails();
    }
}
