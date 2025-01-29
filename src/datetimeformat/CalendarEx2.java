package datetimeformat;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt() - 1;
        int startDayOfWeek = 0;
        int endDate = 0;
        String[] weekDays = {"일", "월", "화", "수", "목", "금", "토"};

        Calendar startDay = Calendar.getInstance();
        startDay.set(year, month, 1);
        Calendar endDay = Calendar.getInstance();
        endDay.set(year, month+1, 1);
        endDay.add(Calendar.DATE, -1);

        startDayOfWeek = startDay.get(Calendar.DAY_OF_WEEK);
        endDate = endDay.get(Calendar.DATE);
        System.out.printf("[%d년 %d월]\n", startDay.get(Calendar.YEAR), startDay.get(Calendar.MONTH) + 1);
        for (int i = 0; i < 7; i++) {
            System.out.print(weekDays[i] + "   ");
        }
        System.out.println();
        for (int i = 0; i < startDayOfWeek; i++) {
            System.out.print("   ");
        }

        boolean isFirstWeek = true;
        for (int i = 1; i <= endDate; i++) { // 합이 7이면 줄바꿈
            System.out.print(i + (i < 10 ? "   " : "  "));
            if (isFirstWeek && startDayOfWeek + i == 8) {
                System.out.print("\n");
                isFirstWeek = false;
            } else if (!isFirstWeek && (i + startDayOfWeek) % 7 == 1) {
                System.out.println();
            }
        }
    }
}
