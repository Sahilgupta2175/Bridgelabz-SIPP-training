public class Q5_Book {
    private String title;
    private String author;
    private double price;
    private boolean available;

    public Q5_Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        this.available = true;
    }

    public Q5_Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    public boolean borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book \"" + title + "\" has been borrowed successfully.");
            return true;
        } else {
            System.out.println("Book \"" + title + "\" is not available for borrowing.");
            return false;
        }
    }

    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Book \"" + title + "\" has been returned successfully.");
        } else {
            System.out.println("Book \"" + title + "\" was not borrowed.");
        }
    }

    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (available ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        Q5_Book book1 = new Q5_Book("Java Programming", "John Smith", 29.99);
        book1.displayDetails();

        System.out.println();
        book1.borrowBook();
        book1.displayDetails();

        System.out.println();
        book1.borrowBook();

        System.out.println();
        book1.returnBook();
        book1.displayDetails();

        System.out.println("\nCreating a book with default constructor:");
        Q5_Book book2 = new Q5_Book();
        book2.displayDetails();
    }
}
