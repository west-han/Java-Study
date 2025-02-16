package mid2.generic.ex1;

public class BoxMain2 {
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10);
        Integer integer = (Integer)integerBox.get();
        System.out.println("integer = " + integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("Hello");
        String string = (String)stringBox.get();
        System.out.println("string = " + string);

        // 잘못된 타입의 인수 전달 시
        integerBox.set("100");
        Integer integer2 = (Integer)integerBox.get(); // String -> Integer 캐스팅 예외
        System.out.println("integer2 = " + integer2);
    }
}
