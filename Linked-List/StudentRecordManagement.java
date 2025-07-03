public class StudentRecordManagement {
    class Student {
        int rollNumber;
        String name;
        int age;
        String grade;
        Student next;

        public Student(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }

    static Student head = null;
    static Student tail = null;
    static int size = size();

    public static void addStudentFirst(int rollNumber, String name, int age, String grade) {
        StudentRecordManagement srm = new StudentRecordManagement();
        Student newStudent = srm.new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = tail = newStudent;
        } else {
            newStudent.next = head;
            head = newStudent;
        }
    }

    public static void addStudentLast(int rollNumber, String name, int age, String grade) {
        StudentRecordManagement srm = new StudentRecordManagement();
        Student newStudent = srm.new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = tail = newStudent;
        } else {
            tail.next = newStudent;
            tail = newStudent;
        }
    }

    public static void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position");
            return;
        }

        StudentRecordManagement srm = new StudentRecordManagement();
        Student newStudent = srm.new Student(rollNumber, name, age, grade);
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        } else if (position == 0) {
            addStudentFirst(rollNumber, name, age, grade);
        } else if (position == size) {
            addStudentLast(rollNumber, name, age, grade);
        } else {
            Student temp = head;
            int index = 0;

            while (index < position - 1) {
                temp = temp.next;
                index++;
            }

            newStudent.next = temp.next;
            temp.next = newStudent;
        }
    }

    public static int size() {
        int count = 0;
        Student temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static void removeStudentFirst() {
        if (head == null) {
            System.out.println("No students to remove.");
            return;
        }

        head = head.next;
    }

    public static void removeStudentLast() {
        if (head == null) {
            System.out.println("No students to remove.");
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Student temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
    }

    public static void removeStudent(int rollNumber) {
        if (head == null) {
            System.out.println("No students to remove.");
            return;
        }

        if (head.rollNumber == rollNumber) {
            removeStudentFirst();
            ;
            return;
        }

        if (tail.rollNumber == rollNumber) {
            removeStudentLast();
            return;
        }

        Student temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.rollNumber == rollNumber) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public static void displayStudents() {
        Student temp = head;

        while (temp != null) {
            System.out.println("Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age
                    + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public static void updateStudent(int rollNumber, String newGrade) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Student with roll number " + rollNumber + " updated to grade " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public static void searchStudent(int rollNumber) {
        Student temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student found: Roll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: "
                        + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    public static void main(String[] args) {
        addStudentFirst(1, "Alice", 20, "A");
        addStudentLast(2, "Bob", 21, "B");
        addStudentAtPosition(3, "Charlie", 22, "C", 1);
        displayStudents();

        updateStudent(2, "A+");
        searchStudent(1);
        removeStudent(3);
        displayStudents();

        removeStudentFirst();
        removeStudentLast();
        displayStudents();
    }
}
