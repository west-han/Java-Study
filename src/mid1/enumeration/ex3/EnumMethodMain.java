package mid1.enumeration.ex3;

import java.util.Arrays;

public class EnumMethodMain {

    public static void main(String[] args) {

        // 모든 ENUM 반환
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values));
        for (Grade value : values) {
            System.out.println("name = " + value.name() + ", ordinal = " + value.ordinal());
        }

        // String -> Enum 변환, 잘못된 문자면 IllegalArgumentException 발생
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("grade = " + gold); // toString() 오버라이딩 가능

        // 상수의 선언 위치가 변할 수 있기 때문에 ordinal을 이용해 값을 식별하고자 해서는 안 됨
        // 열거형 정의 시 자동으로 java.lang.Enum을 상속하고, 타입 안전 열거형 패턴으로 클래스 정의되므로 다른 클래스 상속 불가
        // 열거형은 인터페이스 구현 가능
        // 열거형에 추상 메서드 선언, 구현 가능(익명 클래스와 같은 방식 사용)
    }
}
