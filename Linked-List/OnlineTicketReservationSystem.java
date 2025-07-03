import java.util.Scanner;

public class OnlineTicketReservationSystem {
    class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private Ticket head = null;
    private int size = 0;

    public void addTicketReservation(int ticketId, String customerName, String movieName, String seatNumber,
            String bookingTime) {
        if (findTicketById(ticketId) != null) {
            System.out.println("Ticket with ID " + ticketId + " already exists!");
            return;
        }

        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
        size++;
        System.out.println("Ticket reservation added successfully!");
    }

    public void removeTicketById(int ticketId) {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }

        if (size == 1 && head.ticketId == ticketId) {
            head = null;
            size = 0;
            System.out.println("Ticket with ID " + ticketId + " removed successfully!");
            return;
        }

        Ticket temp = head;
        Ticket prev = null;

        do {
            if (temp.ticketId == ticketId) {
                if (temp == head) {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                size--;
                System.out.println("Ticket with ID " + ticketId + " removed successfully!");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket with ID " + ticketId + " not found!");
    }

    public Ticket findTicketById(int ticketId) {
        if (head == null) {
            return null;
        }

        Ticket temp = head;
        do {
            if (temp.ticketId == ticketId) {
                return temp;
            }
            temp = temp.next;
        } while (temp != head);

        return null;
    }

    public void displayAllTickets() {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }

        System.out.println("All Ticket Reservations:");
        Ticket temp = head;
        int count = 1;

        do {
            System.out.println(count + ". Ticket ID: " + temp.ticketId +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber +
                    ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
            count++;
        } while (temp != head);
    }

    public void searchTicketByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        System.out.println("Tickets for customer '" + customerName + "':");

        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + temp.ticketId +
                        ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for customer: " + customerName);
        }
    }

    public void searchTicketByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        System.out.println("Tickets for movie '" + movieName + "':");

        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketId +
                        ", Customer: " + temp.customerName +
                        ", Seat: " + temp.seatNumber +
                        ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tickets found for movie: " + movieName);
        }
    }

    public void calculateTotalBookedTickets() {
        System.out.println("Total number of booked tickets: " + size);
    }

    public void displayTicketDetails(int ticketId) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket == null) {
            System.out.println("Ticket with ID " + ticketId + " not found!");
            return;
        }

        System.out.println("Ticket Details:");
        System.out.println("Ticket ID: " + ticket.ticketId);
        System.out.println("Customer Name: " + ticket.customerName);
        System.out.println("Movie Name: " + ticket.movieName);
        System.out.println("Seat Number: " + ticket.seatNumber);
        System.out.println("Booking Time: " + ticket.bookingTime);
    }

    public void displayTicketsByMovie() {
        if (head == null) {
            System.out.println("No tickets in the system!");
            return;
        }

        System.out.println("Tickets grouped by movie:");
        Ticket temp = head;
        java.util.Set<String> processedMovies = new java.util.HashSet<>();

        do {
            if (!processedMovies.contains(temp.movieName.toLowerCase())) {
                System.out.println("\nMovie: " + temp.movieName);
                processedMovies.add(temp.movieName.toLowerCase());

                Ticket innerTemp = head;
                int movieTicketCount = 0;
                do {
                    if (innerTemp.movieName.equalsIgnoreCase(temp.movieName)) {
                        System.out.println("  - Ticket ID: " + innerTemp.ticketId +
                                ", Customer: " + innerTemp.customerName +
                                ", Seat: " + innerTemp.seatNumber);
                        movieTicketCount++;
                    }
                    innerTemp = innerTemp.next;
                } while (innerTemp != head);

                System.out.println("  Total tickets for this movie: " + movieTicketCount);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void displayAvailableSeats(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked yet!");
            return;
        }

        System.out.println("Booked seats for movie '" + movieName + "':");
        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Seat " + temp.seatNumber + " - Customer: " + temp.customerName);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No seats booked for movie: " + movieName);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OnlineTicketReservationSystem system = new OnlineTicketReservationSystem();

        while (true) {
            System.out.println("\n=== Online Ticket Reservation System ===");
            System.out.println("1. Add Ticket Reservation");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer Name");
            System.out.println("5. Search Ticket by Movie Name");
            System.out.println("6. Display Ticket Details");
            System.out.println("7. Calculate Total Booked Tickets");
            System.out.println("8. Display Tickets by Movie");
            System.out.println("9. Display Booked Seats for Movie");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter ticket ID: ");
                    int ticketId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter movie name: ");
                    String movieName = scanner.nextLine();
                    System.out.print("Enter seat number: ");
                    String seatNumber = scanner.nextLine();
                    System.out.print("Enter booking time: ");
                    String bookingTime = scanner.nextLine();
                    system.addTicketReservation(ticketId, customerName, movieName, seatNumber, bookingTime);
                    break;

                case 2:
                    System.out.print("Enter ticket ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    system.removeTicketById(idToRemove);
                    break;

                case 3:
                    system.displayAllTickets();
                    break;

                case 4:
                    System.out.print("Enter customer name to search: ");
                    String searchCustomer = scanner.nextLine();
                    system.searchTicketByCustomerName(searchCustomer);
                    break;

                case 5:
                    System.out.print("Enter movie name to search: ");
                    String searchMovie = scanner.nextLine();
                    system.searchTicketByMovieName(searchMovie);
                    break;

                case 6:
                    System.out.print("Enter ticket ID for details: ");
                    int detailsId = scanner.nextInt();
                    system.displayTicketDetails(detailsId);
                    break;

                case 7:
                    system.calculateTotalBookedTickets();
                    break;

                case 8:
                    system.displayTicketsByMovie();
                    break;

                case 9:
                    System.out.print("Enter movie name: ");
                    String movieForSeats = scanner.nextLine();
                    system.displayAvailableSeats(movieForSeats);
                    break;

                case 10:
                    System.out.println("Exiting Ticket Reservation System...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
