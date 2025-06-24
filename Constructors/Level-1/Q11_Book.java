public class Q11_Book {
    public String ISBN;
    protected String title;
    private String author;

    public Q11_Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class Q11_EBook extends Q11_Book {
    private String format;
    private int sizeMB;

    public Q11_EBook(String ISBN, String title, String author, String format, int sizeMB) {
        super(ISBN, title, author);
        this.format = format;
        this.sizeMB = sizeMB;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Format: " + format);
        System.out.println("Size: " + sizeMB + " MB");
    }

    public void demonstrateAccess() {
        System.out.println("Accessing Public Member (ISBN): " + ISBN);
        System.out.println("Accessing Protected Member (Title): " + title);
        System.out.println("Accessing Private Member via getter: " + getAuthor());
    }

    public static void main(String[] args) {
        Q11_Book book = new Q11_Book("978-0134685991", "Effective Java", "Joshua Bloch");
        System.out.println("Regular Book:");
        book.displayDetails();

        System.out.println("\nModifying Author:");
        System.out.println("Current Author: " + book.getAuthor());
        book.setAuthor("Joshua J. Bloch");
        System.out.println("Updated Author: " + book.getAuthor());

        System.out.println("\nE-Book:");
        Q11_EBook eBook = new Q11_EBook("978-0134685991", "Effective Java",
                "Joshua Bloch", "PDF", 12);
        eBook.displayDetails();

        System.out.println("\nDemonstrating Access to Members in EBook:");
        eBook.demonstrateAccess();
    }
}
