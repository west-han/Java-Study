package mid1.lang.string.test;

public class TestString10 {
    public static void main(String[] args) {
        String str = "Hello Java";
        String reverse = new StringBuilder(str).reverse().toString();
        System.out.println("reverse = " + reverse);
    }
}
