import java.util.*;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public boolean searchByAuthor(String author) {
        return this.author.equals(author);
    }
}

class BookBuddy {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        int option;
        do {
            System.out.println("\n1. Add Books\n2. Show all Books\n3. Search Book\n4. Exit");
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    String x = "n";
                    do {
                        System.out.println("Enter Title and Author: (Format title-author)");
                        String input = sc.nextLine();
                        String[] split = input.split("-");

                        if (split.length >= 2) {
                            books.add(new Book(split[0].trim(), split[1].trim()));
                        } else {
                            System.out.println("Invalid format! Please use 'title-author' format.");
                            System.out.println("Do you want to add more books to the list? (y/n)");
                            x = sc.nextLine();
                            continue;
                        }

                        System.out.println("Do you want to add more books to the list? (y/n)");
                        x = sc.nextLine();
                    } while (x.equals("y"));
                    break;

                case 2:
                    System.out.println("All Books:");
                    boolean foundBook = false;
                    for (Book b : books) {
                        b.display();
                        System.out.println();
                        foundBook = true;
                    }
                    if (!foundBook) {
                        System.out.println("No books found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter author name to search: ");
                    String authorToSearch = sc.nextLine();

                    System.out.println("Search result:");
                    boolean found = false;
                    for (Book b : books) {
                        if (b.searchByAuthor(authorToSearch)) {
                            System.out.println("Title: " + b.title);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Author not Found");
                    }
                    break;
            }
        } while (option != 4);

        sc.close();
    }
}