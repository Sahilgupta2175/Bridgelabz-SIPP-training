import java.util.*;

public class LibraryOrganizer {
    private Map<String, LinkedList<String>> genreCatalog;
    private Set<String> bookSet;

    public LibraryOrganizer() {
        genreCatalog = new HashMap<>();
        bookSet = new HashSet<>();
    }

    public void addBook(String genre, String book) {
        if (bookSet.add(book)) {
            genreCatalog.putIfAbsent(genre, new LinkedList<>());
            genreCatalog.get(genre).add(book);
            System.out.println("Added book: " + book + " to genre: " + genre);
        } else {
            System.out.println("Book: " + book + " already exists in the catalog.");
        }
    }

    public void removeBook(String genre, String book) {
        if (bookSet.remove(book)) { 
            LinkedList<String> books = genreCatalog.get(genre);
            if (books != null && books.remove(book)) {
                System.out.println("Removed book: " + book + " from genre: " + genre);
            } else {
                System.out.println("Book: " + book + " not found in genre: " + genre);
            }
        } else {
            System.out.println("Book: " + book + " does not exist in the catalog.");
        }
    }

    public void displayCatalog() {
        System.out.println("Library Catalog:");
        for (Map.Entry<String, LinkedList<String>> entry : genreCatalog.entrySet()) {
            String genre = entry.getKey();
            LinkedList<String> books = entry.getValue();
            System.out.println("Genre: " + genre + " | Books: " + books);
        }
    }

    public static void main(String[] args) {
        LibraryOrganizer library = new LibraryOrganizer();
        library.addBook("Science Fiction", "Dune");
        library.addBook("Fantasy", "The Hobbit");
        library.addBook("Science Fiction", "Neuromancer");
        library.addBook("Fantasy", "The Hobbit"); 
        library.displayCatalog();
        library.removeBook("Fantasy", "The Hobbit");
        library.displayCatalog();
        library.removeBook("Science Fiction", "Dune");
        library.displayCatalog();
        library.removeBook("Mystery", "Unknown Book"); 
    }
}
