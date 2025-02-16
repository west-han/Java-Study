package mid2.generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {
        // 생성 시점에 타입 결정
        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.set(10);
        // integerBox.set("100"); // Integer 타입만 허용, 컴파일 오류
        Integer integer = integerBox.get(); // Integer 타입 반환(캐스팅 X)
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.set("Hello");
        String string = stringBox.get();
        System.out.println("string = " + string);

        // 원하는 모든 타입 사용 가능
        GenericBox<Double> doubleBox = new GenericBox<>();
        doubleBox.set(3.14);
        Double double1 = doubleBox.get();
        System.out.println("double1 = " + double1);

        // 타입 매개변수를 설정하면 컴파일러가 해당 타입이 맞는지 확인해주는 방식
        // Object 다형성을 사용할 때와 달리 컴파일 타임에 타입 체크 -> 타입 안정성 확보
        // 제네릭의 기본 철학은, 클래스를 정의할 때 타입을 결정하지 않고 실제로 클래스를 사용할 때 타입을 결정한다는 점
        // 메서드에서 사용할 값을 메서드에 하드코딩 하는 대신 파라미터로 선언해 메서드 사용 시점까지 값의 결정을 미루는 것과 유사
        // 이러한 관점에서 다이아몬드(<>) 안에 전달하는 타입 정보를 타입 파라미터라고 부른다.

        // 타입 추론: 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<Integer>();
    }
}
