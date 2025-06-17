import java.util.Scanner;

public class Q9_MinMaxThreeNumbers {
    public static int[] findSmallestAndLargest(int a, int b, int c) {
        int min = Math.min(a, Math.min(b, c));
        int max = Math.max(a, Math.max(b, c));
        return new int[] { min, max };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        int n1 = sc.nextInt();
        System.out.print("Enter number 2: ");
        int n2 = sc.nextInt();
        System.out.print("Enter number 3: ");
        int n3 = sc.nextInt();

        int[] result = findSmallestAndLargest(n1, n2, n3);
        System.out.println("Smallest: " + result[0]);
        System.out.println("Largest: " + result[1]);
        sc.close();
    }
}
