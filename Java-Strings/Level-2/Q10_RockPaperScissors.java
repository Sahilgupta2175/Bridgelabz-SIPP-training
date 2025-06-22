import java.util.Scanner;

class Q10_RockPaperScissors {

    public static String getComputerChoice() {
        int random = (int) (Math.random() * 3);
        return switch (random) {
            case 0 -> "rock";
            case 1 -> "paper";
            default -> "scissors";
        };
    }

    public static String determineWinner(String user, String comp) {
        if (user.equals(comp))
            return "Draw";
        return switch (user + "-" + comp) {
            case "rock-scissors", "paper-rock", "scissors-paper" -> "Player";
            default -> "Computer";
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, compWins = 0;

        System.out.print("Enter number of rounds: ");
        int rounds = sc.nextInt();

        for (int i = 0; i < rounds; i++) {
            System.out.print("Choose rock, paper, or scissors: ");
            String user = sc.next().toLowerCase();
            String comp = getComputerChoice();
            String winner = determineWinner(user, comp);

            System.out.printf("You: %s | Computer: %s | Winner: %s\n", user, comp, winner);
            if (winner.equals("Player"))
                userWins++;
            else if (winner.equals("Computer"))
                compWins++;
        }

        double userPct = (userWins * 100.0) / rounds;
        double compPct = (compWins * 100.0) / rounds;

        System.out.println("\nFinal Stats:");
        System.out.printf("Player Wins: %d (%.2f%%)\n", userWins, userPct);
        System.out.printf("Computer Wins: %d (%.2f%%)\n", compWins, compPct);
        sc.close();
    }
}
