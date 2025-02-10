package mid1.time.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.Scanner;

public class TestCalendarPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("년도를 입력하세요: ");
        int year = scanner.nextInt();
        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();

        LocalDate date = LocalDate.of(year, month, 1);
        int offset = date.get(ChronoField.DAY_OF_WEEK);

        System.out.println("SU MO TU WE TH FR SA");
        for (int i = 0; i < offset; i++) {
            System.out.print("   ");
        }

        LocalDate nextMonth = date.plusMonths(1);
        LocalDate dateIterator = date;
        while (dateIterator.isBefore(nextMonth)) {
            System.out.printf("%02d ", dateIterator.getDayOfMonth());
            if (dateIterator.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
            dateIterator = dateIterator.plusDays(1);
        }
    }
}
