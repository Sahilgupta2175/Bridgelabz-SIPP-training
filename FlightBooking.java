import java.time.LocalDate;
import java.time.LocalTime;

public class FlightBooking {

    static class Passenger {
        String name;
        TicketBookingDetails[] ticketBookingDetails;

        public Passenger(String name, TicketBookingDetails[] ticketBookingDetails) {
            this.name = name;
            this.ticketBookingDetails = ticketBookingDetails;
        }
    }

    static class FlightData {
        String flightNumber;
        String departureAirportCode;
        String arrivalAirportCode;
        LocalDate departureDate;
        LocalTime departureTime;
        String seatNumber;
        String boardingGate;
        String boardingTime;
        String travelClass;

        public FlightData(String flightNumber, String departureAirportCode, String arrivalAirportCode,
                LocalDate departureDate, LocalTime departureTime, String seatNumber,
                String boardingGate, String boardingTime, String travelClass) {
            this.flightNumber = flightNumber;
            this.departureAirportCode = departureAirportCode;
            this.arrivalAirportCode = arrivalAirportCode;
            this.departureDate = departureDate;
            this.departureTime = departureTime;
            this.seatNumber = seatNumber;
            this.boardingGate = boardingGate;
            this.boardingTime = boardingTime;
            this.travelClass = travelClass;
        }
    }

    static class TicketBookingDetails {

        String passengerName;
        String flightNumber;
        String bookingReference; // PNR number
        String departureAirportCode;
        String arrivalAirportCode;
        LocalDate departureDate;
        LocalTime departureTime;
        String seatNumber;
        String boardingGate;
        String boardingTime;
        String travelClass;

        public TicketBookingDetails(String passengerName, String flightNumber, String bookingReference,
                String departureAirportCode, String arrivalAirportCode, LocalDate departureDate,
                LocalTime departureTime, String seatNumber, String boardingGate, String boardingTime,
                String travelClass) {
            this.passengerName = passengerName;
            this.flightNumber = flightNumber;
            this.bookingReference = bookingReference;
            this.departureAirportCode = departureAirportCode;
            this.arrivalAirportCode = arrivalAirportCode;
            this.departureDate = departureDate;
            this.departureTime = departureTime;
            this.seatNumber = seatNumber;
            this.boardingGate = boardingGate;
            this.boardingTime = boardingTime;
            this.travelClass = travelClass;
        }

    }

    public static void printTicketDetails(TicketBookingDetails ticket) {
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│                         TICKET DETAILS                         │");
        System.out.println("├─────────────────────────────┬───────────────────────────────────┤");
        System.out.printf("│ %-27s │ %-33s │%n", "Passenger Name", ticket.passengerName);
        System.out.printf("│ %-27s │ %-33s │%n", "Flight Number", ticket.flightNumber);
        System.out.printf("│ %-27s │ %-33s │%n", "Booking Reference (PNR)", ticket.bookingReference);
        System.out.printf("│ %-27s │ %-33s │%n", "Departure Airport", ticket.departureAirportCode);
        System.out.printf("│ %-27s │ %-33s │%n", "Arrival Airport", ticket.arrivalAirportCode);
        System.out.printf("│ %-27s │ %-33s │%n", "Departure Date", ticket.departureDate);
        System.out.printf("│ %-27s │ %-33s │%n", "Departure Time", ticket.departureTime);
        System.out.printf("│ %-27s │ %-33s │%n", "Seat Number", ticket.seatNumber);
        System.out.printf("│ %-27s │ %-33s │%n", "Boarding Gate", ticket.boardingGate);
        System.out.printf("│ %-27s │ %-33s │%n", "Boarding Time", ticket.boardingTime);
        System.out.printf("│ %-27s │ %-33s │%n", "Travel Class", ticket.travelClass);
        System.out.println("└─────────────────────────────┴───────────────────────────────────┘");
    }

    public static void printPassengerDetails(Passenger passenger) {
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│                      PASSENGER INFORMATION                     │");
        System.out.println("├─────────────────────────────┬───────────────────────────────────┤");
        System.out.printf("│ %-27s │ %-33s │%n", "Passenger Name", passenger.name);
        System.out.println("└─────────────────────────────┴───────────────────────────────────┘");
        System.out.println();

        if (passenger.ticketBookingDetails.length == 0) {
            System.out.println("No tickets booked for this passenger.");
            return;
        }

        System.out.println("BOOKED TICKETS:");
        for (int i = 0; i < passenger.ticketBookingDetails.length; i++) {
            System.out.println("\nTicket " + (i + 1) + ":");
            printTicketDetails(passenger.ticketBookingDetails[i]);
        }
    }

    public static void printFlightData(FlightData flight) {
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│                         FLIGHT DETAILS                         │");
        System.out.println("├─────────────────────────────┬───────────────────────────────────┤");
        System.out.printf("│ %-27s │ %-33s │%n", "Flight Number", flight.flightNumber);
        System.out.printf("│ %-27s │ %-33s │%n", "Departure Airport", flight.departureAirportCode);
        System.out.printf("│ %-27s │ %-33s │%n", "Arrival Airport", flight.arrivalAirportCode);
        System.out.printf("│ %-27s │ %-33s │%n", "Departure Date", flight.departureDate);
        System.out.printf("│ %-27s │ %-33s │%n", "Departure Time", flight.departureTime);
        System.out.printf("│ %-27s │ %-33s │%n", "Seat Number", flight.seatNumber);
        System.out.printf("│ %-27s │ %-33s │%n", "Boarding Gate", flight.boardingGate);
        System.out.printf("│ %-27s │ %-33s │%n", "Boarding Time", flight.boardingTime);
        System.out.printf("│ %-27s │ %-33s │%n", "Travel Class", flight.travelClass);
        System.out.println("└─────────────────────────────┴───────────────────────────────────┘");
    }

    public static void searchFlight(String flightNumber, FlightData[] flights) {
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│                      FLIGHT SEARCH RESULT                      │");
        System.out.println("└─────────────────────────────────────────────────────────────────┘");
        System.out.println("Searching for flight: " + flightNumber);
        System.out.println();

        for (FlightData flight : flights) {
            if (flight.flightNumber.equals(flightNumber)) {
                System.out.println("✅ Flight Found!");
                printFlightData(flight);
                return;
            }
        }
        System.out.println("❌ Flight not found.");
    }

    public static void bookTicket(Passenger passenger, FlightData flight, String bookingReference) {
        TicketBookingDetails ticket = new TicketBookingDetails(
                passenger.name,
                flight.flightNumber,
                bookingReference,
                flight.departureAirportCode,
                flight.arrivalAirportCode,
                flight.departureDate,
                flight.departureTime,
                flight.seatNumber,
                flight.boardingGate,
                flight.boardingTime,
                flight.travelClass);
        passenger.ticketBookingDetails = new TicketBookingDetails[] { ticket };

        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│                      BOOKING CONFIRMATION                      │");
        System.out.println("└─────────────────────────────────────────────────────────────────┘");
        System.out.println("✅ Ticket booked successfully for " + passenger.name);
        System.out.println();
        printTicketDetails(ticket);
    }

    public static void displayAvailableFlights(FlightData[] flights) {
        System.out.println(
                "┌──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println(
                "│                                                    AVAILABLE FLIGHTS                                                    │");
        System.out.println(
                "├──────────┬─────────┬─────────┬──────────────┬──────────────┬──────────┬─────────────┬──────────────┬─────────────────┤");
        System.out.println(
                "│ Flight   │ From    │ To      │ Date         │ Time         │ Seat     │ Gate        │ Boarding     │ Class           │");
        System.out.println(
                "├──────────┼─────────┼─────────┼──────────────┼──────────────┼──────────┼─────────────┼──────────────┼─────────────────┤");

        for (FlightData flight : flights) {
            System.out.printf("│ %-8s │ %-7s │ %-7s │ %-12s │ %-12s │ %-8s │ %-11s │ %-12s │ %-15s │%n",
                    flight.flightNumber,
                    flight.departureAirportCode,
                    flight.arrivalAirportCode,
                    flight.departureDate,
                    flight.departureTime,
                    flight.seatNumber,
                    flight.boardingGate,
                    flight.boardingTime,
                    flight.travelClass);
        }
        System.out.println(
                "└──────────┴─────────┴─────────┴──────────────┴──────────────┴──────────┴─────────────┴──────────────┴─────────────────┘");
    }

    public static void main(String[] args) {

        // Sample flight data
        FlightData flight1 = new FlightData("AI202", "DEL", "BOM", LocalDate.of(2023, 10, 15),
                LocalTime.of(10, 30), "12A", "Gate 5", "10:00 AM", "Economy");
        FlightData flight2 = new FlightData("AI303", "BOM", "CCU", LocalDate.of(2023, 10, 16),
                LocalTime.of(14, 45), "15B", "Gate 3", "2:15 PM", "Business");

        FlightData[] flights = { flight1, flight2 };

        // Sample passenger
        Passenger passenger = new Passenger("John Doe", new TicketBookingDetails[] {});

        // Display system header
        System.out.println("=".repeat(70));
        System.out.println("           FLIGHT BOOKING SYSTEM - DEMO");
        System.out.println("=".repeat(70));
        System.out.println();

        // Display all available flights
        displayAvailableFlights(flights);
        System.out.println();

        // Search for a flight
        searchFlight("AI202", flights);
        System.out.println();

        // Book a ticket
        bookTicket(passenger, flight1, "PNR123456");
        System.out.println();

        // Print passenger details
        printPassengerDetails(passenger);

    }

}