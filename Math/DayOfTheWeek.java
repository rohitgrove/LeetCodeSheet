public class DayOfTheWeek {
    public static boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static String dayOfTheWeek(int day, int month, int year) {
        String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

        int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int totalDays = 0;

        // Step 1: count days from 1971 to (year - 1)
        for (int y = 1971; y < year; y++) {
            totalDays += isLeap(y) ? 366 : 365;
        }

        // Step 2: count days for months in current year
        for (int m = 1; m < month; m++) {
            if (m == 2 && isLeap(year)) {
                totalDays += 29;
            } else {
                totalDays += monthDays[m - 1];
            }
        }

        // Step 3: add current day
        totalDays += day;

        // Step 4: find day (1971-01-01 was Friday → offset = 4)
        return days[(totalDays + 4) % 7];
    }

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek(15, 8, 1993));
    }
}
