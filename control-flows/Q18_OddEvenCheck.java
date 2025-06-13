import java.util.Scanner;
public class Q18_OddEvenCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                if (i % 2 == 0)
                    System.out.println(i + " is even");
                else
                    System.out.println(i + " is odd");
            }
        } else {
            System.out.println("Invalid input");
        }
    }
}
