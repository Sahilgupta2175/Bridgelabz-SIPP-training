import java.util.Scanner;
public class Q29_MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt(), counter = 99;
        if (number > 0 && number < 100) {
            while (counter > 1) {
                if (counter % number == 0)
                    System.out.println(counter);
                counter--;
            }
        } else {
            System.out.println("Invalid input");
        }
    }
}
