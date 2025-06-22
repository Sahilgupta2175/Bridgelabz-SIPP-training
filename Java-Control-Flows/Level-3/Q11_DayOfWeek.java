public class Q11_DayOfWeek {
    public static void main(String[] args) {
        int d = 22, m = 6, y = 2025;

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int dayOfWeek = (d + x + 31 * m0 / 12) % 7;

        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        System.out.println("Day: " + days[dayOfWeek]);
    }
}
