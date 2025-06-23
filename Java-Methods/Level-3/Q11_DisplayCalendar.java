import java.util.Scanner;

public class Q11_DisplayCalendar {

    static String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getStartDay(int year, int month) {
        int d = 1, y = year;
        if (month < 3) {
            month += 12;
            y -= 1;
        }

        return (d + 2 * month + 3 * (month + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
    }

    public static void display(int year, int month) {
        int daysInMonth = days[month - 1];
        if (month == 2 && isLeap(year)) {
            daysInMonth = 29;
        }
        int startDay = getStartDay(year, month);

        System.out.printf("\n%s %d\nSun Mon Tue Wed Thu Fri Sat\n", months[month - 1], year);
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        display(year, month);
        sc.close();
    }
}
