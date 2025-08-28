import java.util.*;
import java.util.stream.Collectors;

class Movie {
    String name;
    double rating;
    int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String toString() {
        return name + " (" + releaseYear + ", Rating: " + rating + ")";
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.5, 2023),
                new Movie("Movie B", 9.0, 2024),
                new Movie("Movie C", 7.8, 2022),
                new Movie("Movie D", 8.9, 2024),
                new Movie("Movie E", 8.7, 2023),
                new Movie("Movie F", 9.2, 2025),
                new Movie("Movie G", 8.8, 2025));
        List<Movie> top5 = movies.stream()
                .sorted(Comparator.comparingDouble((Movie m) -> m.rating).reversed()
                        .thenComparing((Movie m) -> -m.releaseYear))
                .limit(5)
                .collect(Collectors.toList());
        top5.forEach(System.out::println);
    }
}
