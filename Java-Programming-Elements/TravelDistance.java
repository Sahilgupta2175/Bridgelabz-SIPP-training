import java.util.Scanner;

public class TravelDistance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter from city: ");
        String fromCity = input.nextLine();
        System.out.print("Enter via city: ");
        String viaCity = input.nextLine();
        System.out.print("Enter to city: ");
        String toCity = input.nextLine();
        System.out.print("Enter distance from to via (miles): ");
        double fromToVia = input.nextDouble();
        System.out.print("Enter distance via to final (miles): ");
        double viaToFinalCity = input.nextDouble();
        System.out.print("Enter time from to via (minutes): ");
        double timeFromToVia = input.nextDouble();
        System.out.print("Enter time from via to final (minutes): ");
        double timeViaToFinalCity = input.nextDouble();
        double totalDistanceKm = (fromToVia + viaToFinalCity) * 1.6;
        double totalTime = timeFromToVia + timeViaToFinalCity;
        System.out.printf("The Total Distance travelled by %s from %s to %s via %s is %.2f km and the Total Time taken is %.2f minutes%n",
                         name, fromCity, toCity, viaCity, totalDistanceKm, totalTime);
        input.close();
    }
}