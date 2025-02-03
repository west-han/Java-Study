package mid1.lang.string.test;

public class TestString2 {
    public static void main(String[] args) {
        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int length = 0;
        for (String s : arr) {
            length += s.length();
            System.out.println(s + ":" + s.length());
        }
        System.out.println("sum = " + length);
    }
}
