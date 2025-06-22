import java.util.Scanner;

public class Q8_CountdownWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counter = sc.nextInt();
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }
        sc.close();
    }
}
