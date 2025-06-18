import java.util.Scanner;

public class Q18_RockPaperScissorsGame {

    public static String getComputerChoice() {
        String[] choices = { "rock", "paper", "scissors" };
        return choices[(int) (Math.random() * 3)];
    }

    public static String getWinner(String user, String comp) {
        if (user.equals(comp))
            return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
                (user.equals("paper") && comp.equals("rock")) ||
                (user.equals("scissors") && comp.equals("paper")))
            return "User";
        return "Computer";
    }

    public static void displayStats(int userWins, int compWins, int games) {
        double userPercent = (userWins * 100.0) / games;
        double compPercent = (compWins * 100.0) / games;
        System.out.println("Games Played: " + games);
        System.out.println("User Wins: " + userWins + " (" + Math.round(userPercent) + "%)");
        System.out.println("Computer Wins: " + compWins + " (" + Math.round(compPercent) + "%)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        int userWins = 0, compWins = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("rock/paper/scissors: ");
            String user = sc.next().toLowerCase();
            String comp = getComputerChoice();
            String winner = getWinner(user, comp);
            System.out.println("Computer chose: " + comp);
            System.out.println("Winner: " + winner);
            if (winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                compWins++;
        }

        displayStats(userWins, compWins, n);
        sc.close();
    }
}
