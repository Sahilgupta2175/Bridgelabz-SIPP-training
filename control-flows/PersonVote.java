import java.util.Scanner;

public class PersonVote {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your age: ");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.printf("The person's age is %d and can vote.", age);
        } else {
            System.out.printf("The person's age is %d and cannot vote.", age);
        }

        input.close();
    }
}
