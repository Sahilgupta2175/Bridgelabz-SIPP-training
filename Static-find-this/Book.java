/**
 * Book class for Library Management System
 * Demonstrates static variables, static methods, this keyword, final variables,
 * and instanceof
 */
public class Book {
    // Static variable shared across all books - represents the library name
    private static String libraryName = "Central City Library";

    // Static variable to track total number of books in the library
    private static int totalBooks = 0;

    // Instance variables
    private String title;
    private String author;

    // Final variable - ISBN cannot be changed once assigned
    private final String isbn;

    private boolean isAvailable;
    private String genre;

    /**
     * Constructor to create a new book
     * Uses 'this' keyword to initialize instance variables when parameter names
     * match
     * 
     * @param title  Title of the book
     * @param author Author of the book
     * @param isbn   Unique ISBN number for the book
     * @param genre  Genre/category of the book
     */
    public Book(String title, String author, String isbn, String genre) {
        // Using 'this' to distinguish between instance variables and parameters
        this.title = title;
        this.author = author;
        this.genre = genre;

        // Final variable assignment - can only be done once during initialization
        this.isbn = isbn;

        // By default, newly added books are available
        this.isAvailable = true;

        // Increment static counter for total books
        totalBooks++;
    }

    /**
     * Static method to display the library name
     * Can be called without creating an instance of the Book class
     */
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
        System.out.println("Welcome to " + libraryName + "!");
    }

    /**
     * Static method to get total number of books in the library
     * 
     * @return Total count of books
     */
    public static int getTotalBooks() {
        return totalBooks;
    }

    /**
     * Static method to change the library name
     * 
     * @param newLibraryName New name for the library
     */
    public static void setLibraryName(String newLibraryName) {
        libraryName = newLibraryName;
        System.out.println("Library name updated to: " + libraryName);
    }

    /**
     * Method to issue/checkout a book
     */
    public void issueBook() {
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println("Book '" + this.title + "' has been issued successfully.");
        } else {
            System.out.println("Sorry, the book '" + this.title + "' is currently not available.");
        }
    }

    /**
     * Method to return a book
     */
    public void returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            System.out.println("Book '" + this.title + "' has been returned successfully.");
        } else {
            System.out.println("This book was not issued, so it cannot be returned.");
        }
    }

    /**
     * Method to display detailed book information
     * This method is called only after instanceof verification
     */
    public void displayBookDetails() {
        System.out.println("\n=== Book Details ===");
        System.out.println("Library: " + libraryName);
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Genre: " + this.genre);
        System.out.println("Available: " + (this.isAvailable ? "Yes" : "No"));
        System.out.println("====================");
    }

    /**
     * Static method to safely display book information using instanceof
     * Demonstrates type checking before casting and method invocation
     * 
     * @param obj Object to be verified and displayed
     */
    public static void displayBookInfo(Object obj) {
        // Using instanceof to verify the object type before processing
        if (obj instanceof Book) {
            System.out.println("Valid Book object detected!");
            Book book = (Book) obj; // Safe casting after instanceof check
            book.displayBookDetails();
        } else {
            System.out.println("Error: Object is not an instance of Book class!");
            System.out.println("Cannot display book information for: " + obj.getClass().getSimpleName());
        }
    }

    /**
     * Method to search for books by title (case-insensitive)
     * 
     * @param searchTitle Title to search for
     * @return true if title matches, false otherwise
     */
    public boolean searchByTitle(String searchTitle) {
        return this.title.toLowerCase().contains(searchTitle.toLowerCase());
    }

    /**
     * Getter methods for accessing private fields
     */
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn; // Final variable - read-only access
    }

    public String getGenre() {
        return this.genre;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

    public static String getLibraryName() {
        return libraryName;
    }

    /**
     * Main method to demonstrate the Book class functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Library Management System Demo ===\n");

        // Display library information using static method
        Book.displayLibraryName();
        System.out.println("Initial books count: " + Book.getTotalBooks());

        // Create book instances
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5", "Fiction");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4", "Fiction");
        Book book3 = new Book("1984", "George Orwell", "978-0-452-28423-4", "Dystopian Fiction");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "978-0-14-143951-8", "Romance");

        // Display updated book count
        System.out.println("\nAfter adding books:");
        System.out.println("Total books in library: " + Book.getTotalBooks());

        // Demonstrate book operations
        System.out.println("\n=== Book Operations ===");
        book1.issueBook();
        book1.issueBook(); // Try to issue already issued book
        book1.returnBook();
        book1.returnBook(); // Try to return already returned book

        book2.issueBook();
        book3.issueBook();

        // Demonstrate instanceof usage with valid Book objects
        System.out.println("\n=== Instanceof Demonstration ===");
        Book.displayBookInfo(book1);
        Book.displayBookInfo(book2);
        Book.displayBookInfo(book3);
        Book.displayBookInfo(book4);

        // Demonstrate instanceof with invalid objects
        String invalidObject1 = "This is not a Book";
        Integer invalidObject2 = 12345;
        Book.displayBookInfo(invalidObject1);
        Book.displayBookInfo(invalidObject2);

        // Demonstrate library name change
        System.out.println("\n=== Library Name Change Demo ===");
        Book.setLibraryName("Metropolitan Public Library");
        Book.displayLibraryName();

        // Display a book to show updated library name
        Book.displayBookInfo(book1);

        // Final variable demonstration
        System.out.println("\n=== Final Variable Demo ===");
        System.out.println("Book ISBN (final variable): " + book1.getIsbn());
        // book1.isbn = "NEW-ISBN"; // Uncommenting this would cause compilation error

        // Search functionality demonstration
        System.out.println("\n=== Search Functionality ===");
        String searchTerm = "gatsby";
        System.out.println("Searching for books containing '" + searchTerm + "':");

        Book[] allBooks = { book1, book2, book3, book4 };
        for (Book book : allBooks) {
            if (book.searchByTitle(searchTerm)) {
                System.out.println("Found: " + book.getTitle() + " by " + book.getAuthor());
            }
        }

        System.out.println("\nFinal library statistics:");
        System.out.println("Library: " + Book.getLibraryName());
        System.out.println("Total books: " + Book.getTotalBooks());
    }
}
