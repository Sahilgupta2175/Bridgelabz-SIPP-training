import java.util.Scanner;

public class Q20_ArrayAnalysis {

    public static boolean isPositive(int n) {
        return n > 0;
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();

            if (isPositive(arr[i])) {
                if (isEven(arr[i]))
                    System.out.println("Positive and Even");
                else
                    System.out.println("Positive and Odd");
            } else if (arr[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        int result = compare(arr[0], arr[4]);
        if (result == 0) {
            System.out.println("First and Last elements are Equal");
        } else if (result > 0) {
            System.out.println("First element is Greater than Last");
        } else {
            System.out.println("First element is Less than Last");
        }
        sc.close();
    }
}
