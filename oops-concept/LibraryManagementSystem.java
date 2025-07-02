abstract class LibraryItem {
    protected String itemId;
    protected String title;
    protected String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

interface Reservable {
    void reserveItem();

    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private String borrowerName;
    private String borrowerContact;
    private boolean isAvailable;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            isAvailable = false;
            System.out.println("Book reserved successfully");
        } else {
            System.out.println("Book is not available for reservation");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    private void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    private void setBorrowerContact(String borrowerContact) {
        this.borrowerContact = borrowerContact;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private String borrowerName;
    private String borrowerContact;
    private boolean isAvailable;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            isAvailable = false;
            System.out.println("Magazine reserved successfully");
        } else {
            System.out.println("Magazine is not available for reservation");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    private void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    private void setBorrowerContact(String borrowerContact) {
        this.borrowerContact = borrowerContact;
    }
}

class DVD extends LibraryItem implements Reservable {
    private String borrowerName;
    private String borrowerContact;
    private boolean isAvailable;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem() {
        if (checkAvailability()) {
            isAvailable = false;
            System.out.println("DVD reserved successfully");
        } else {
            System.out.println("DVD is not available for reservation");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    private void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    private void setBorrowerContact(String borrowerContact) {
        this.borrowerContact = borrowerContact;
    }
}

public class LibraryManagementSystem {
    public static void manageItems(LibraryItem[] items) {
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
                ((Reservable) item).reserveItem();
            }
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {
        LibraryItem[] items = {
                new Book("B001", "Java Programming", "John Smith"),
                new Magazine("M001", "Tech Today", "Tech Publications"),
                new DVD("D001", "Learning Java", "Educational Videos")
        };

        manageItems(items);
    }
}
