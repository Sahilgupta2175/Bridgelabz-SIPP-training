import java.util.Scanner;

public class MovieManagementSystem {
    class Movie {
        String title;
        String director;
        int yearOfRelease;
        double rating;
        Movie next;
        Movie prev;

        public Movie(String title, String director, int yearOfRelease, double rating) {
            this.title = title;
            this.director = director;
            this.yearOfRelease = yearOfRelease;
            this.rating = rating;
            this.next = null;
            this.prev = null;
        }
    }

    private Movie head = null;
    private Movie tail = null;
    private int size = 0;

    public void addMovieAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        size++;
        System.out.println("Movie added at beginning successfully!");
    }

    public void addMovieAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        size++;
        System.out.println("Movie added at end successfully!");
    }

    public void addMovieAtPosition(String title, String director, int yearOfRelease, double rating, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Position should be between 0 and " + size);
            return;
        }

        if (position == 0) {
            addMovieAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        if (position == size) {
            addMovieAtEnd(title, director, yearOfRelease, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        Movie current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        newMovie.next = current;
        newMovie.prev = current.prev;
        current.prev.next = newMovie;
        current.prev = newMovie;
        size++;
        System.out.println("Movie added at position " + position + " successfully!");
    }

    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("No movies in the list!");
            return;
        }

        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else if (current == head) {
                    head = current.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                size--;
                System.out.println("Movie '" + title + "' removed successfully!");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found!");
    }

    public void searchMovieByDirector(String director) {
        if (head == null) {
            System.out.println("No movies in the list!");
            return;
        }

        Movie current = head;
        boolean found = false;
        System.out.println("Movies directed by " + director + ":");
        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println(
                        "Title: " + current.title + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    public void searchMovieByRating(double rating) {
        if (head == null) {
            System.out.println("No movies in the list!");
            return;
        }

        Movie current = head;
        boolean found = false;
        System.out.println("Movies with rating " + rating + ":");
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: "
                        + current.yearOfRelease);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list!");
            return;
        }

        System.out.println("Movies in forward order:");
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayReverse() {
        if (head == null) {
            System.out.println("No movies in the list!");
            return;
        }

        System.out.println("Movies in reverse order:");
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director +
                    ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        if (head == null) {
            System.out.println("No movies in the list!");
            return;
        }

        Movie current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated successfully for movie: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManagementSystem system = new MovieManagementSystem();

        while (true) {
            System.out.println("\n=== Movie Management System ===");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search Movie by Director");
            System.out.println("6. Search Movie by Rating");
            System.out.println("7. Display Movies (Forward)");
            System.out.println("8. Display Movies (Reverse)");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter movie title: ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director1 = scanner.nextLine();
                    System.out.print("Enter year of release: ");
                    int year1 = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating1 = scanner.nextDouble();
                    system.addMovieAtBeginning(title1, director1, year1, rating1);
                    break;

                case 2:
                    System.out.print("Enter movie title: ");
                    String title2 = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director2 = scanner.nextLine();
                    System.out.print("Enter year of release: ");
                    int year2 = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating2 = scanner.nextDouble();
                    system.addMovieAtEnd(title2, director2, year2, rating2);
                    break;

                case 3:
                    System.out.print("Enter movie title: ");
                    String title3 = scanner.nextLine();
                    System.out.print("Enter director: ");
                    String director3 = scanner.nextLine();
                    System.out.print("Enter year of release: ");
                    int year3 = scanner.nextInt();
                    System.out.print("Enter rating: ");
                    double rating3 = scanner.nextDouble();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    system.addMovieAtPosition(title3, director3, year3, rating3, position);
                    break;

                case 4:
                    System.out.print("Enter movie title to remove: ");
                    String titleToRemove = scanner.nextLine();
                    system.removeMovieByTitle(titleToRemove);
                    break;

                case 5:
                    System.out.print("Enter director name: ");
                    String directorToSearch = scanner.nextLine();
                    system.searchMovieByDirector(directorToSearch);
                    break;

                case 6:
                    System.out.print("Enter rating to search: ");
                    double ratingToSearch = scanner.nextDouble();
                    system.searchMovieByRating(ratingToSearch);
                    break;

                case 7:
                    system.displayForward();
                    break;

                case 8:
                    system.displayReverse();
                    break;

                case 9:
                    System.out.print("Enter movie title: ");
                    String titleToUpdate = scanner.nextLine();
                    System.out.print("Enter new rating: ");
                    double newRating = scanner.nextDouble();
                    system.updateRating(titleToUpdate, newRating);
                    break;

                case 10:
                    System.out.println("Exiting Movie Management System...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
