package mid1.time.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

public class TestZone {
    public static void main(String[] args) {
        ZonedDateTime seoul = ZonedDateTime.of(LocalDateTime.of(2024, 1, 1, 9, 0, 0), ZoneId.of("Asia/Seoul"));
        System.out.println("서울의 회의 시간: " + seoul);
        ZonedDateTime london = seoul.withZoneSameInstant(ZoneId.of("Europe/London"));
        System.out.println("런던의 회의 시간: " + london);
        ZonedDateTime newYork = london.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("뉴욕의 회의 시간: " + newYork);
    }
}
