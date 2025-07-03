import java.util.Scanner;

public class LibraryManagementSystem {
    class Book {
        String bookTitle;
        String author;
        String genre;
        int bookId;
        boolean availabilityStatus;
        Book next;
        Book prev;

        public Book(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
            this.bookTitle = bookTitle;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.availabilityStatus = availabilityStatus;
            this.next = null;
            this.prev = null;
        }
    }

    private Book head = null;
    private Book tail = null;
    private int size = 0;

    public void addBookAtBeginning(String bookTitle, String author, String genre, int bookId,
            boolean availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        size++;
        System.out.println("Book added at beginning successfully!");
    }

    public void addBookAtEnd(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        size++;
        System.out.println("Book added at end successfully!");
    }

    public void addBookAtPosition(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus,
            int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position! Position should be between 0 and " + size);
            return;
        }

        if (position == 0) {
            addBookAtBeginning(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }

        if (position == size) {
            addBookAtEnd(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }

        Book newBook = new Book(bookTitle, author, genre, bookId, availabilityStatus);
        Book current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }

        newBook.next = current;
        newBook.prev = current.prev;
        current.prev.next = newBook;
        current.prev = newBook;
        size++;
        System.out.println("Book added at position " + position + " successfully!");
    }

    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }

        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
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
                System.out.println("Book with ID " + bookId + " removed successfully!");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found!");
    }

    public void searchBookByTitle(String bookTitle) {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }

        Book current = head;
        boolean found = false;
        System.out.println("Books with title '" + bookTitle + "':");
        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(bookTitle)) {
                System.out.println("Book ID: " + current.bookId + ", Author: " + current.author +
                        ", Genre: " + current.genre + ", Available: " + current.availabilityStatus);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found with title: " + bookTitle);
        }
    }

    public void searchBookByAuthor(String author) {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }

        Book current = head;
        boolean found = false;
        System.out.println("Books by author '" + author + "':");
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Book ID: " + current.bookId + ", Title: " + current.bookTitle +
                        ", Genre: " + current.genre + ", Available: " + current.availabilityStatus);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    public void updateAvailabilityStatus(int bookId, boolean newStatus) {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }

        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.availabilityStatus = newStatus;
                System.out.println("Availability status updated successfully for book ID: " + bookId);
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found!");
    }

    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }

        System.out.println("Books in forward order:");
        Book current = head;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". Title: " + current.bookTitle + ", Author: " + current.author +
                    ", Genre: " + current.genre + ", ID: " + current.bookId +
                    ", Available: " + current.availabilityStatus);
            current = current.next;
            count++;
        }
    }

    public void displayBooksReverse() {
        if (head == null) {
            System.out.println("No books in the library!");
            return;
        }

        System.out.println("Books in reverse order:");
        Book current = tail;
        int count = size;
        while (current != null) {
            System.out.println(count + ". Title: " + current.bookTitle + ", Author: " + current.author +
                    ", Genre: " + current.genre + ", ID: " + current.bookId +
                    ", Available: " + current.availabilityStatus);
            current = current.prev;
            count--;
        }
    }

    public void countTotalBooks() {
        System.out.println("Total number of books in the library: " + size);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibraryManagementSystem library = new LibraryManagementSystem();

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display Books (Forward)");
            System.out.println("9. Display Books (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title1 = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author1 = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre1 = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int id1 = scanner.nextInt();
                    System.out.print("Is book available? (true/false): ");
                    boolean status1 = scanner.nextBoolean();
                    library.addBookAtBeginning(title1, author1, genre1, id1, status1);
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String title2 = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author2 = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre2 = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int id2 = scanner.nextInt();
                    System.out.print("Is book available? (true/false): ");
                    boolean status2 = scanner.nextBoolean();
                    library.addBookAtEnd(title2, author2, genre2, id2, status2);
                    break;

                case 3:
                    System.out.print("Enter book title: ");
                    String title3 = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author3 = scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre3 = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int id3 = scanner.nextInt();
                    System.out.print("Is book available? (true/false): ");
                    boolean status3 = scanner.nextBoolean();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    library.addBookAtPosition(title3, author3, genre3, id3, status3, position);
                    break;

                case 4:
                    System.out.print("Enter book ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    library.removeBookById(idToRemove);
                    break;

                case 5:
                    System.out.print("Enter book title to search: ");
                    String titleToSearch = scanner.nextLine();
                    library.searchBookByTitle(titleToSearch);
                    break;

                case 6:
                    System.out.print("Enter author name to search: ");
                    String authorToSearch = scanner.nextLine();
                    library.searchBookByAuthor(authorToSearch);
                    break;

                case 7:
                    System.out.print("Enter book ID: ");
                    int idToUpdate = scanner.nextInt();
                    System.out.print("Enter new availability status (true/false): ");
                    boolean newStatus = scanner.nextBoolean();
                    library.updateAvailabilityStatus(idToUpdate, newStatus);
                    break;

                case 8:
                    library.displayBooksForward();
                    break;

                case 9:
                    library.displayBooksReverse();
                    break;

                case 10:
                    library.countTotalBooks();
                    break;

                case 11:
                    System.out.println("Exiting Library Management System...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
