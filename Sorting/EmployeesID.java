import java.util.*;

public class EmployeesID {
    public static void insertionSort(int[] employeeId) {
        for (int i = 1; i < employeeId.length; i++) {
            int key = employeeId[i];
            int j = i - 1;

            while (j >= 0 && employeeId[j] > key) {
                employeeId[j + 1] = employeeId[j];
                j = j - 1;
            }
            employeeId[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total employees id number: ");
        int n = sc.nextInt();

        int[] employeeId = new int[n];

        System.out.println("Enter the employees id");

        for (int i = 0; i < employeeId.length; i++) {
            employeeId[i] = sc.nextInt();
        }

        insertionSort(employeeId);

        System.out.println("Sorted employees id :");

        System.out.println(Arrays.toString(employeeId));

        sc.close();
    }
}
