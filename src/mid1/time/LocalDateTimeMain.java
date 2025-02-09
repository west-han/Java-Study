package mid1.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {
    public static void main(String[] args) {
        LocalDateTime nowDt = LocalDateTime.now();
        LocalDateTime ofDt = LocalDateTime.of(2020, 2, 29, 8, 10, 1);
        System.out.println("현재 날짜시간: " + nowDt);
        System.out.println("지정 날짜시간: " + ofDt);

        // 날짜와 시간 분리
        LocalDate localDate = ofDt.toLocalDate();
        LocalTime localTime = ofDt.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

        // 날짜와 시간 합체
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime);

        // 계산(불변)1
        LocalDateTime ofDtPlus = ofDt.plusDays(1000);
        System.out.println("지정 날짜시간 + 1000d = " + ofDtPlus);
        LocalDateTime ofDtPlus1Year = ofDt.plusYears(1);
        System.out.println("지정 날짜시간 _ 1년 = " + ofDtPlus1Year);

        // 비교
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이전인가? " + nowDt.isBefore(ofDtPlus));
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이후인가? " + nowDt.isAfter(ofDtPlus));
        System.out.println("현재 날짜시간이 지정 날짜시간과 같은가? " + nowDt.isEqual(ofDtPlus));

        // isEquals(): 객체가 다르고 타임존이 달라도 실제 시간이 같으면 true 반환
        // equals(): 객체의 타입, 타임존 등 내부 구성요소가 모두 같아야 true 반환
    }
}
