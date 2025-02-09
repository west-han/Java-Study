package mid1.time;

import java.time.LocalDate;

public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2022, 12, 2);
        System.out.println("오늘 날짜: " + nowDate);
        System.out.println("지정 날짜: " + ofDate);

        // 계산(불변)
        ofDate = ofDate.plusDays(30);
        System.out.println("지정 날짜 + 10d: " + ofDate);
    }
}
