import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class QuizResultProcessor {
    private final String[] correctAnswers;
    private final List<Integer> userScores;

    public QuizResultProcessor(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
        this.userScores = new ArrayList<>();
    }

    public int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Answer length mismatch.");
        }
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        userScores.add(score);
        return score;
    }


    public String getGrade(int score) {
        int total = correctAnswers.length;
        double percent = (double) score / total * 100;
        if (percent >= 90) return "A";
        else if (percent >= 80) return "B";
        else if (percent >= 70) return "C";
        else if (percent >= 60) return "D";
        else return "F";
    }

    public List<Integer> getUserScores() {
        return userScores;
    }

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number of Questions: ");
        int n=sc.nextInt();

        System.out.println("Enter Correct Answers: ");
        String[] correct=new String[n];
        for(int i=0;i<n;i++){
            correct[i]= sc.next();
        }

        QuizResultProcessor processor = new QuizResultProcessor(correct);

        System.out.print("Enter number of users: ");
        int numUsers = sc.nextInt();

        for (int user = 1; user <= numUsers; user++) {
            System.out.println("\nUser " + user + " - Enter your answers: ");
            String[] userSubmissions = new String[n];
            for(int i=0;i<n;i++){
                System.out.print("Q " + (i+1) + ": ");
                userSubmissions[i]= sc.next();
            }

            try {
                int score = processor.calculateScore(userSubmissions);
                String grade = processor.getGrade(score);
                System.out.println("User " + user + " - Score: " + score + "/" + correct.length + ", Grade: " + grade);
            } catch (InvalidQuizSubmissionException e) {
                System.out.println("User " + user + " - Invalid submission: " + e.getMessage());
            }
        }

        System.out.println("\nAll user scores: " + processor.getUserScores());
        sc.close();
    }
}