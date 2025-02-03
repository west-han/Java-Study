package mid1.lang.string.test;

public class TestString8 {
    public static void main(String[] args) {
        String email = "hello@example.com";
        String[] parts = email.split("@");
        for (String s : parts) {
            System.out.println(s);
        }
    }
}
