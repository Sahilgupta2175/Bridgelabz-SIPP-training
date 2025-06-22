import java.util.Scanner;

public class Q1_OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                System.out.println(i + " is " + (i % 2 == 0 ? "Even" : "Odd"));
            }
        } else {
            System.out.println("Enter a natural number.");
        }
        sc.close();
    }
}
