package mid2.generic.ex1;

public class RawTypeMain {
    public static void main(String[] args) {
        // 하위 버전 호환성을 위해 타입인수 생략
        GenericBox integerBox = new GenericBox();
//        GenericBox<Object> integerBox = new GenericBox<>();
        integerBox.set(10);
        Integer integer = (Integer) integerBox.get();
        System.out.println("integer = " + integer);
    }
}
