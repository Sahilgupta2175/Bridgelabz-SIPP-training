import java.util.Scanner;
public class Q17_MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number > 0 && number < 100) {
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0)
                    System.out.println(i);
            }
        } else {
            System.out.println("Invalid input");
        }
    }
}
