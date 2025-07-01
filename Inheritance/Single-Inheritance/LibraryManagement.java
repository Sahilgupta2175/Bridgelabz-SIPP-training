class Book {
    protected String title;
    protected int publicationYear;
    protected String genre;
    protected String isbn;

    public Book(String title, int publicationYear, String genre, String isbn) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.isbn = isbn;
    }

    public void displayInfo() {
        System.out.println("=== BOOK INFORMATION ===");
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
        System.out.println("Genre: " + genre);
        System.out.println("ISBN: " + isbn);
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isVintage() {
        return (2024 - publicationYear) > 50;
    }
}

class Author extends Book {
    private String authorName;
    private String bio;
    private String nationality;
    private int birthYear;

    public Author(String title, int publicationYear, String genre, String isbn,
            String authorName, String bio, String nationality, int birthYear) {
        super(title, publicationYear, genre, isbn);
        this.authorName = authorName;
        this.bio = bio;
        this.nationality = nationality;
        this.birthYear = birthYear;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("=== AUTHOR INFORMATION ===");
        System.out.println("Author Name: " + authorName);
        System.out.println("Nationality: " + nationality);
        System.out.println("Birth Year: " + birthYear);
        System.out.println("Bio: " + bio);
        System.out.println("Author Age when published: " + (publicationYear - birthYear) + " years");
    }

    public void writeReview() {
        System.out.println("Writing a review for '" + title + "' by " + authorName);
    }

    public boolean isAuthorAlive() {
        int estimatedDeathYear = birthYear + 80;
        return 2024 < estimatedDeathYear;
    }

    public String getPublicationEra() {
        if (publicationYear < 1900) {
            return "19th Century";
        } else if (publicationYear < 1950) {
            return "Early 20th Century";
        } else if (publicationYear < 1990) {
            return "Mid 20th Century";
        } else {
            return "Modern Era";
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getBio() {
        return bio;
    }

    public String getNationality() {
        return nationality;
    }

    public int getBirthYear() {
        return birthYear;
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===\n");

        Book book1 = new Book("The Great Gatsby", 1925, "Fiction", "978-0-7432-7356-5");
        Book book2 = new Book("To Kill a Mockingbird", 1960, "Fiction", "978-0-06-112008-4");

        Author author1 = new Author("1984", 1949, "Dystopian Fiction", "978-0-452-28423-4",
                "George Orwell", "English novelist and journalist known for his dystopian novels",
                "British", 1903);

        Author author2 = new Author("Pride and Prejudice", 1813, "Romance", "978-0-14-143951-8",
                "Jane Austen", "English novelist known for her social commentary and wit",
                "British", 1775);

        System.out.println("1. Display Book Information (Superclass):");
        book1.displayInfo();
        System.out.println("Is Vintage: " + book1.isVintage());
        System.out.println();

        book2.displayInfo();
        System.out.println("Is Vintage: " + book2.isVintage());
        System.out.println();

        System.out.println("2. Display Author Information (Single Inheritance - Subclass):");
        author1.displayInfo();
        System.out.println("Publication Era: " + author1.getPublicationEra());
        System.out.println("Is Vintage: " + author1.isVintage());
        System.out.println();

        author2.displayInfo();
        System.out.println("Publication Era: " + author2.getPublicationEra());
        System.out.println("Is Vintage: " + author2.isVintage());
        System.out.println();

        System.out.println("3. Author-specific Methods:");
        author1.writeReview();
        author2.writeReview();
        System.out.println();

        System.out.println("4. Library Catalog Summary:");
        System.out.println("Books in catalog:");
        System.out.println("- " + book1.getTitle() + " (" + book1.getPublicationYear() + ")");
        System.out.println("- " + book2.getTitle() + " (" + book2.getPublicationYear() + ")");
        System.out.println("- " + author1.getTitle() + " by " + author1.getAuthorName() + " ("
                + author1.getPublicationYear() + ")");
        System.out.println("- " + author2.getTitle() + " by " + author2.getAuthorName() + " ("
                + author2.getPublicationYear() + ")");

        System.out.println("\n=== End of Library Management Demo ===");
    }
}
