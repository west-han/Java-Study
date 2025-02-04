package mid1.lang.wrapper;

public class WrapperUtilsMain {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(10); // 숫자, 래퍼 객체 반환
        Integer i2 = Integer.valueOf("10"); // 문자열, 래퍼 객체 반환
        int intValue = Integer.parseInt("10"); // 문자열 전용, 기본형 반환
        /* Wrapper 객체가 필요하면 valueOf, 기본형이 필요하면 parseInt 사용 */

        // 비교
        int compareResult = i1.compareTo(i2);
        System.out.println("compareResult = " + compareResult);

        // 산술연산
        System.out.println("sum: " + Integer.sum(10, 20));
        System.out.println("max: " + Integer.max(10, 20));
        System.out.println("min: " + Integer.min(10, 20));
    }
}
