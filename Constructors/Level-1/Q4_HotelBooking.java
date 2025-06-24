public class Q4_HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    public Q4_HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }

    public Q4_HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public Q4_HotelBooking(Q4_HotelBooking otherBooking) {
        this.guestName = otherBooking.guestName;
        this.roomType = otherBooking.roomType;
        this.nights = otherBooking.nights;
    }

    public void displayDetails() {
        System.out.println("Booking Details:");
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
    }

    public static void main(String[] args) {
        Q4_HotelBooking booking1 = new Q4_HotelBooking();
        System.out.println("Booking with default constructor:");
        booking1.displayDetails();

        System.out.println("\nBooking with parameterized constructor:");
        Q4_HotelBooking booking2 = new Q4_HotelBooking("John Smith", "Deluxe", 3);
        booking2.displayDetails();

        System.out.println("\nBooking with copy constructor:");
        Q4_HotelBooking booking3 = new Q4_HotelBooking(booking2);
        booking3.displayDetails();

        booking3.guestName = "Jane Doe";
        booking3.nights = 5;

        System.out.println("\nOriginal booking after modifying copy:");
        booking2.displayDetails();

        System.out.println("\nCopied booking after modification:");
        booking3.displayDetails();
    }
}
