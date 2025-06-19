import java.util.Scanner;
import java.util.Random;

public class Q1_NumberGuessingGame {
    static Scanner scanner = new Scanner(System.in);

    public static String getFeedback(int guess) {
        System.out.print("Is the guess " + guess + " too high, too low, or correct? ");
        return scanner.nextLine().toLowerCase();
    }

    public static void playGame() {
        int low = 1, high = 100;
        Random random = new Random();
        String feedback;
        int guess;

        System.out.println("Think of a number between 1 and 100.");

        do {
            guess = random.nextInt(high - low + 1) + low;
            feedback = getFeedback(guess);

            if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            }

        } while (!feedback.equals("correct"));

        System.out.println("Yay! Guessed the number correctly: " + guess);
    }

    public static void main(String[] args) {
        playGame();
    }
}
