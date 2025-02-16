package mid2.generic.ex4;

public class MethodMain1 {
    public static void main(String[] args) {
        Integer i = 10;
        Object object = GenericMethod.objMethod(i);

        // 타입 인수(Type Argument) 명시적 전달
        System.out.println("명시적 타입 인수 전달");
        Integer result = GenericMethod.<Integer>genericMethod(i);
        Integer integerValue = GenericMethod.<Integer>numberMethod(10);
        Double doubleValue = GenericMethod.<Double>numberMethod(20.0);
        // 제네릭 메서드의 타입은 호출 시점에 타입 인수를 전달해서 결정(제네릭 타입은 객체 생성 시점에 타입 인수를 전달해서 결정)
        // 제네릭 메서드도 타입 추론 가능, 따라서 타입 명시를 생략해도 무방(컴파일러가 전달되는 인수의 타입을 기반으로 추론)
    }
}
