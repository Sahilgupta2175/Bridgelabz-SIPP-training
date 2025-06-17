import java.util.Scanner;

public class Q32_MonthlyCalendar {

    static final String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    static final int[] daysInMonth = {
            0, 31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getStartDay(int month, int year) {
        int y = year;
        int m = month;
        if (m < 3) {
            m += 12;
            y--;
        }
        int d = 1;
        int k = y % 100;
        int j = y / 100;
        int h = (d + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j) % 7;
        return (h + 6) % 7; // convert to Sunday = 0
    }

    public static void printCalendar(int month, int year) {
        int days = daysInMonth[month];
        if (month == 2 && isLeapYear(year))
            days = 29;

        System.out.println("     " + months[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int startDay = getStartDay(month, year);
        for (int i = 0; i < startDay; i++)
            System.out.print("    ");

        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        printCalendar(month, year);
        sc.close();
    }
}
