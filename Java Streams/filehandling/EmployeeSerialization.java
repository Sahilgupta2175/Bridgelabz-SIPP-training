import java.io.*;
import java.util.*;

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "A", "HR", 50000));
        list.add(new Employee(2, "B", "IT", 60000));
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) {
            List<Employee> emps = (List<Employee>) ois.readObject();
            for (Employee emp : emps) {
                System.out.println(emp.id + " " + emp.name + " " + emp.department + " " + emp.salary);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
