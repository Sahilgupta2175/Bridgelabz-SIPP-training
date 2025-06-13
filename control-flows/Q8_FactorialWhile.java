import java.util.Scanner;
public class Q8_FactorialWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num >= 0) {
            int factorial = 1, i = 1;
            while (i <= num) {
                factorial *= i;
                i++;
            }
            System.out.println("Factorial: " + factorial);
        } else {
            System.out.println("Invalid input");
        }
    }
}
