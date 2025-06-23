public class Q4_MovieTicketBooking {

    static class MovieTicket {
        String movieName;
        String seatNumber;
        double price;

        public void bookTicket(String movieName, String seatNumber, double price) {
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public void displayTicket() {
            System.out.println("Movie Name : " + movieName);
            System.out.println("Seat No.   : " + seatNumber);
            System.out.println("Price      : ₹" + price);
        }
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Avengers: Endgame", "A12", 350);
        ticket.displayTicket();
    }
}
