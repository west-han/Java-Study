package bibleofjava.datetimeformat;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

// java.time 패키지는 JDK1.8에서 추가된 날짜, 시간을 다루는 패키지
// 기존의 Date, Calendar와 달리 불변이라 멀티 스레드 환경에서 안전
public class TimePackage {
    public static void main(String[] args) {
        // 날짜는 LocalDate, 시간은 LocalTime, 날짜와 시간 모두 다루려면 LocalDateTime, 시간대(timezone)까지 필요하면 ZonedDateTime
        // LocalDate, LocalTime, LocalDateTime, Instant 등은 Temporal, TemporalAccessor, TemporalAdjuster 인터페이스를 구현
        // Period: 두 날짜 간의 차이, Duration: 시간의 차이
        // Period, Duration 등은 TemporalAmount 인터페이스를 구현 -> 시간의 간격을 나타내기 위한 인터페이스
        // now(): 현재 날짜와 시간을 저장하는 객체 생성, of(): 생성자에 정해진 순서대로 값을 전달해서 날짜, 시간 지정
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        LocalDate date1 = date;
        System.out.println(date1);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zonedDateTime);
        time = LocalTime.of(14, 30, 20);
        System.out.println(time);
        dateTime = LocalDateTime.of(date1, time);
        System.out.println(dateTime);

        // TemporalUnit 인터페이스는 날짜와 시간의 단위를 정의, TemporalField 인터페이스는 년/월/일 등 날짜와 시간의 필드를 정의
        // TemporalUnit -> ChronoUnit, TemporalField -> ChronoField
        LocalTime now = LocalTime.now();
        int minute = now.getMinute();
        // minute = now.get(ChronoField.MINUTE_OF_HOUR);

        // with(), withXXX(), plus(), plusXXX(), minus(), minusXXX() 등으로 필드 값 변경(불변객체이므로 새로 생성한 반환)
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        // tomorrow = today.plusDays(1);
        LocalDate firstDay = today.withDayOfMonth(1);
        System.out.println(firstDay);
        // truncatedTo(): 지정한 시간 단위 아래의 필드를 0으로 절삭
        now = LocalTime.now();
        System.out.println(now);
        LocalTime truncated = now.truncatedTo(ChronoUnit.HOURS);
        System.out.println(truncated);

        // 날짜와 시간의 비교는 isAfter(), isBefore(), isEqual() 사용
        // isEqual() 메서드는 모든 필드가 일치해야 하는 equals() 메서드와 달리 연표가 다른 두 날짜의 상등 비교 가능
        LocalDate dateA = LocalDate.of(2002, 04, 02);
        LocalDate dateB = LocalDate.of(2002, 04, 04);
        System.out.println(dateA.isAfter(dateB));

        // Instant는 에포크타임(1970-01-01 00:00:00 UTC)부터 경과된 시간을 나노초 단위로 표현(단일 진법이라 계산 용이)
        // Date 클래스를 대체하기 위한 클래스
        Instant instant = Instant.now();
        Instant instant1 = instant.ofEpochSecond(instant.getEpochSecond());
        int nano = instant.getNano();

        Date fromInstant = Date.from(instant);
        Instant fromDate = fromInstant.toInstant();

        // LocalDateTime은 LocalDate와 LocalTime을 합성한 것
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDateTime localDateTime2 = localDate.atTime(localTime);
        LocalDateTime localDateTime3 = localTime.atDate(localDate);

        // ZoneId 클래스: 시간대(서머타임 자동 적용)
        ZoneId zoneId = ZoneId.of("Asia/Seoul");
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(zoneId);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDate, localTime, zoneId);
        // ZoneOffset: 시간대의 차이(UTC 기준)
        ZoneOffset krOffset = ZoneOffset.of("+09:00");
        int krOffsetInSec = krOffset.get(ChronoField.OFFSET_SECONDS);

        // OffsetDateTime
        // ZonedDateTime 클래스와의 차이점은 ZoneId가 아닌 ZoneOffset을 사용하므로 시간의 차이만으로 시간대를 구분한다는 것
        // ZoneId는 서머타임이 적용되어 있지만, ZoneOffset은 그렇지 않음. 유동적인 시간체계 대신 일관적인 시간체계를 사용하는 것이 더 안전함
        OffsetDateTime odt = OffsetDateTime.of(localDateTime, krOffset);

        // TemporalAdjusters: 자주 사용될만한 날짜 계산들을 대신 해주는 메서드를 정의한 클래스
        LocalDate ld = LocalDate.now();
        LocalDate nextMonday = ld.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // 다음주 월요일의 날짜를 계산해주는 메서드

        // Period: 날짜 차이, Duration: 시간 차이
        Period pe = Period.between(ld, nextMonday);
        LocalTime lt1 = LocalTime.of(10, 20, 30);
        LocalTime lt2 = LocalTime.of(20, 10, 40);
        Duration du = Duration.between(lt1, lt2); // 클래스 메서드
        Period until = ld.until(LocalDate.now()); // 인스턴스 메서드
        System.out.println(pe.get(ChronoUnit.DAYS));
        System.out.println(du.get(ChronoUnit.SECONDS));
        System.out.println(du.getUnits()); // Duration 객체에 저장된 값은 초, 나노초 단위로만 확인할 수 있으므로 시간, 분 차이는 직접 계산

        LocalTime tmp = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
        int diffMinutes = tmp.getMinute();
        System.out.println(diffMinutes);

        Period pe2 = pe.plusYears(1).multipliedBy(2);
        long totalMonths = pe2.toTotalMonths();
        long hours = du.toHours(); // get()은 필드의 값을 그대로 가져오는 메서드이지만 toXXX는 변환해서 반환하는 것이므로 Duration도 분, 시간 단위 출력 가능

        // DateTimeFormatter -> 자주 쓰이는 형식을 기본적으로 정의
        String yyyymmdd1 = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        String yyyymmdd2 = DateTimeFormatter.ISO_LOCAL_DATE.format(LocalDate.now());
        System.out.println(yyyymmdd1);
        System.out.println(yyyymmdd2);

        // 로케일에 종속된 형식화
        DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
        System.out.println(LocalDateTime.now().format(dtf));

        // SimpleDateFormat과 같은 방식으로 패턴 설정 가능, 생성자에 패턴 문자열을 넘기는 SDF와 달리 DTF는 Thread-safe하므로 더 권장됨
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(LocalDateTime.now().format(dtf2));

        // 문자열을 날짜 또는 시간으로 변환하려면 날짜, 시간 관련 클래스에 정의된 정적 메서드 parse() 사용
        // 형식을 지정하기 위한 두번째 파라미터로 형식화 상수 또는 DateTimeFormatter 객체 사용 가능
        LocalDate parsedDate1 = LocalDate.parse("2025-01-30");
        LocalDate parsedDate2 = LocalDate.parse("2025-01-30", DateTimeFormatter.ISO_LOCAL_DATE);
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate3 = LocalDate.parse("2025-01-30", dtf3);
        System.out.println(parsedDate1);
        System.out.println(parsedDate2);
        System.out.println(parsedDate3);
    }
}
