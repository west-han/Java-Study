package mid1.lang.wrapper;

public class MyIntegerMethodMain1 {
    public static void main(String[] args) {
        MyInteger value = new MyInteger(10);
        int i1 = value.compareTo(5);
        int i2 = value.compareTo(10);
        int i3 = value.compareTo(30);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }
}
