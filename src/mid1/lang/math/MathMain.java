package mid1.lang.math;

public class MathMain {
    public static void main(String[] args) {
        // 기본 연산
        System.out.println("Math.max(10, 20) = " + Math.max(10, 20));
        System.out.println("Math.min(10, 20) = " + Math.min(10, 20));
        System.out.println("Math.abs(-10) = " + Math.abs(-10));

        // 반올림 및 정밀도 메서드
        System.out.println("Math.ceil(2.1) = " + Math.ceil(2.1)); // 올림
        System.out.println("Math.floor(2.7) = " + Math.floor(2.7)); // 내림
        System.out.println("Math.round(2.5) = " + Math.round(2.5)); // 반올림

        // 기타 유용한 메서드
        System.out.println("Math.sqrt(4) = " + Math.sqrt(4)); // 제곱근
        System.out.println("Math.random() = " + Math.random()); // 0.0 ~ 1.0 사이의 double 값

        // 금액 등 정밀도가 중요한 소수점 연산은 부동소수점 자료형 대신 BigDecimal 사용
    }
}
