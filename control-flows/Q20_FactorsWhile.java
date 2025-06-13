import java.util.Scanner;
public class Q20_FactorsWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), i = 1;
        if (number > 0) {
            while (i < number) {
                if (number % i == 0)
                    System.out.println(i);
                i++;
            }
        } else {
            System.out.println("Invalid input");
        }
    }
}
