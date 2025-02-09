package mid1.time;

import java.time.ZoneId;

public class ZonedMain {
    public static void main(String[] args) {
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println(zoneId + " | " + zoneId.getRules());
        }

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId = " + zoneId);

        ZoneId newYorkZoneId = ZoneId.of("America/New_York");
        System.out.println("newYorkZoneId = " + newYorkZoneId);
        // ZoneId는 내부적으로 일광 절약 시간 관련 정보, UTC와의 오프셋 정보를 포함
    }
}
