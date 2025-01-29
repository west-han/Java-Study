package datetimeformat;

import java.text.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

// 형식화 클래스 -> 데이터를 원하는 형식으로 표현
public class Formatter {
    public static void main(String[] args) {
        // DecimalFormat: 숫자 데이터를 정수, 부동소수점, 금액 등으로 표현
        // 원하는 출력형식 패턴 작성해서 인스턴스 생성, 출력하고자 하는 문자열로 format 메서드 호출하면 패턴에 맞게 변환
        /*
         - 0: 10진수(값 없으면 0)
         - #: 10진수
         - .: 소수점
         - -: 음수부호
         - ,: 단위 구분자(숫자)
         - ;: 패턴 구분자(패턴 여러개 작성 시)
         - %: 퍼센트
         - \\u2030: 퍼밀(퍼센트 * 10)
         - \\u00A4: 통화(통화기호)
         - ': escape 문자(패턴 기호를 그대로 출력하기 위한)
         */
        String[] patterns = {"0", "#", "0.0", "#.#", "0000000.0000", "#######.####", "#.#-", "-#.#", "#,###.##+;#,###.##-", "#.#########E0"};
        double number = 1234567.89;
        for (String pattern : patterns) {
            DecimalFormat df = new DecimalFormat(pattern);
            System.out.println(df.format(number));
        }
        System.out.println();
        // 특정 패턴의 문자열을 숫자로 변환
        DecimalFormat df = new DecimalFormat("#,###.###");
        try {
            Number num = df.parse("1,234,567.891");
            System.out.println(num);
            System.out.println(num.doubleValue());
            System.out.println(num.longValue());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        // SimpleDateFormat: Date 객체의 날짜 정보를 특정 형식에 맞춰 출력
        // w: 년의 n번째 주, W: 월의 n번째 주
        // D: 년의 n번째 일
        // d: 월의 n번째 일
        // F: 월의 n번째 요일
        // E: 요일
        // H: 0~23 k: 1~24 K: 1~12
        SimpleDateFormat sdf = new SimpleDateFormat("'ADBC': G | 'year': y yy yyyy | 'mon': M MM | 'week': w ww W WW | 'day': D DD d dd | \n'F': F 'E': E | 'ampm':  a | 'hour': H HH k KK h | 'min': m mm | 'sec': s S | 'timezone': z Z");
        String date = sdf.format(new Date());
        System.out.println(date);
        // Calendar 객체는 지원하지 않으므로 Date 객체로 변환해서 출력
        Calendar calendar = Calendar.getInstance();
//        Date d = new Date(calendar.getTimeInMillis());
        Date d = calendar.getTime();
        System.out.println(sdf.format(d));

        // 특정 형식의 문자열에서 날짜 추출
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
        try {
            Date parsedDate = sdf2.parse("20250202");
            System.out.println(parsedDate);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(parsedDate));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // ChoiceFormat: 특정 범위에 속하는 값을 문자열로 변환
        double[] limits = {0, 70, 90};
        String[] grades = {"F", "B", "A"};
        ChoiceFormat cf = new ChoiceFormat(limits, grades);
        System.out.println(cf.format(70));
        ChoiceFormat cf2 = new ChoiceFormat("0#F|70#B|90#A"); // #: 범위 기준값과 치환할 문자열 구분, |: 구간 구분
        System.out.println(cf2.format(60));
        System.out.println(cf2.format(70));
        System.out.println(cf2.format(90));

        System.out.println();

        // MessageFormat: 데이터를 정해진 양식에 맞게 출력
        String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";
        Object[] arguments = {"이름", "010-1111-2222", "20", "2000-03-03"};
        MessageFormat mf = new MessageFormat(msg);
        String message = mf.format(arguments);
        System.out.println(message);
        try {
            Object[] parsedData = mf.parse(message);
            System.out.println(Arrays.toString(parsedData));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
