import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

public class CinemaTime {
    private final List<String> movieTitles = new ArrayList<>();
    private final List<String> showTimes = new ArrayList<>();

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!time.matches("([01]?\\d|2[0-3]):[0-5]\\d")) {
            throw new InvalidTimeFormatException("Invalid time format: " + time);
        }
        movieTitles.add(title);
        showTimes.add(time);
    }

    public void searchMovie(String keyword) {
        boolean found = false;
        for (int i = 0; i < movieTitles.size(); i++) {
            if (movieTitles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.printf("Found: %s at %s%n", movieTitles.get(i), showTimes.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching movie found.");
        }
    }

    public void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.printf("Movie: %s | Showtime: %s%n", movieTitles.get(i), showTimes.get(i));
        }
    }

    public void printReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        System.out.println("\nPrintable Report:");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " - " + timesArray[i]);
        }
    }

    public static void main(String...args) {
        CinemaTime manager = new CinemaTime();
        try {
            manager.addMovie("Inception", "14:30");
            manager.addMovie("Avengers", "17:45");
            manager.addMovie("The Batman", "20:00");
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        manager.displayAllMovies();
        manager.searchMovie("bat");
        manager.printReport();
    }
}