package datetimeformat;

import java.util.Calendar;
import java.util.Date;

public class CalenderEx1 {
    public static void main(String[] args) {
        // Date: JDK1.0부터 제공, 기능을 보완한 Calendar 등장 이후 잘 사용하지 않음
        // Calendar: 추상 클래스, 국가나 문화권마다 다른 역법을 쓰기 때문에 문화권에 맞게 구현해서 쓰도록 설계
        // 구현 클래스는 GregorianCalendar, BuddhistCalendar
        // Calendar.getInstance() 메서드 호출 시 시스템의 국가, 지역설정을 확인해 적절한 인스턴스 반환
        // Calendar calendar = new Calendar(); // 오류
        Calendar calendar = Calendar.getInstance();

        // Date, Calendar 변환
        Date date = new Date(calendar.getTimeInMillis()); // Date(long date)
        date = calendar.getTime(); // Date 객체 반환
        date = new Date();
        calendar = Calendar.getInstance();
        calendar.setTime(date);

        // Calendar에서 연, 월, 일, 시, 분, 초를 꺼낼 때는 Calendar에 정의된 상수 사용
        // * 월은 1~12가 아니라 0~11, 요일은 1~7(1: 일요일)
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));

        // 날짜 차이
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);
        Calendar now = Calendar.getInstance();
        long diff = now.getTimeInMillis() - yesterday.getTimeInMillis();
        int diffDays = (int) (diff / 1000/60/60/24);
        System.out.println(diffDays);

        // 날짜 덧셈
        calendar.add(Calendar.DATE, 1); // (년월일시분초, 변화량)
        calendar.roll(Calendar.DATE, 50); // roll()은 add()와 달리 범위를 넘어가도 다른 필드에 영향을 미치지 않는다.(올림/내림X)
        // 단, DATE 필드가 월말일 때 MONTH 필드를 변경하면 일 필드는 해당 월의 말일 날짜로 변경될 수 있음
        System.out.println(calendar.get(Calendar.MONTH));
    }
}
