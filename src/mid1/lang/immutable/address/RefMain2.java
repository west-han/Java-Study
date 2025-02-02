package mid1.lang.immutable.address;

public class RefMain2 {
    public static void main(String[] args) {
        // 공유 참조가 문제가 되는 이유는 단순히 객체를 공유하기 때문이 아니라, 객체에 접근해서 상태를 변경할 수 있기 때문
        // -> 객체의 상태를 변경할 수 없도록 불변 객체를 생성해 사용하면 해결
        ImmutableAddress a = new ImmutableAddress("서울");
        ImmutableAddress b = a; // Java에 참조값의 대입을 막을 수 있는 방법은 없다.

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        // b.setValue("부산"); // 불가능
        b = new ImmutableAddress("부산");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
