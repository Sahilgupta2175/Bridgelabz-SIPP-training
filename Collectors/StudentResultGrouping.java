import java.util.*;
import java.util.stream.Collectors;

public class StudentResultGrouping {
    static class Student {
        String name;
        String grade;

        Student(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getGrade() {
            return grade;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", "A"),
                new Student("Bob", "B"),
                new Student("Charlie", "A"),
                new Student("David", "C"),
                new Student("Eva", "B"));
        Map<String, List<String>> grouped = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGrade,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(grouped);
    }
}
