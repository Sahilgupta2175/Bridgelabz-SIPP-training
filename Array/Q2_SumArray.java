import java.util.Scanner;

public class Q2_SumArray {
    public static void main(String[] args) {
        double[] arr = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter value: ");
            double input = sc.nextDouble();
            if (input <= 0 || index == 10)
                break;
            arr[index++] = input;
        }

        for (int i = 0; i < index; i++) {
            total += arr[i];
            System.out.println("Value " + (i + 1) + ": " + arr[i]);
        }
        System.out.println("Total: " + total);
        sc.close();
    }
}
