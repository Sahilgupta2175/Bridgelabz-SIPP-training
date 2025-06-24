public class Q1_Book {
    private String title;
    private String author;
    private double price;

    public Q1_Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    public Q1_Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        Q1_Book book1 = new Q1_Book();
        book1.displayDetails();

        System.out.println("\n");

        Q1_Book book2 = new Q1_Book("Java Programming", "John Smith", 29.99);
        book2.displayDetails();
    }
}
