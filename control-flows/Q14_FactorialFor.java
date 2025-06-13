import java.util.Scanner;
public class Q14_FactorialFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(), factorial = 1;
        if (num >= 0) {
            for (int i = 1; i <= num; i++)
                factorial *= i;
            System.out.println("Factorial: " + factorial);
        } else {
            System.out.println("Invalid input");
        }
    }
}
