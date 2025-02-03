package mid1.lang.wrapper;

public class WrapperClassMain {

    public static void main(String[] args) {
        // boxing
        // Wrapper 클래스의 생성자는 Deprecated(미래에 삭제될 수 있음)
        Integer newInteger = new Integer(10);
        Integer integerObj = Integer.valueOf(10); // -128 ~ 127 자주 사용하는 숫자 값 재사용(캐싱), 불변 객체
        Long longObj = Long.valueOf(100);
        Double doubleObj = Double.valueOf(10.5);

        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);
        System.out.println("longObj = " + longObj);
        System.out.println("doubleObj = " + doubleObj);

        // unboxing
        System.out.println("내부 값 읽기");
        int intValue = integerObj.intValue();
        System.out.println("intValue = " + intValue);
        long longValue = longObj.longValue();
        System.out.println("longValue = " + longValue);

        System.out.println("비교");

        // false, new 연산자로 생성한 경우 미리 캐싱된 객체를 사용하지 않고 새로 생성하기 때문
        System.out.println("==: " + (newInteger == integerObj));

        // true
        System.out.println("==: " + (integerObj == Integer.valueOf(10)));

        System.out.println("equals: " + (newInteger.equals(integerObj)));
    }
}
