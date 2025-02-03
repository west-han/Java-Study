package mid1.lang.string.method;

public class StringSearchMain {

    public static void main(String[] args) {
        String s = "Hello, Java! Welcome to Java world.";

        System.out.println("문자열에 'Java'가 포함되어 있는지: " + s.contains("Java"));
        System.out.println("'Java'의 첫 번째 인덱스: " + s.indexOf("Java"));
        System.out.println("인덱스 10부터 'Java'의 인덱스: " + s.indexOf("Java", 10));
        System.out.println("'Java'의 마지막 인덱스: " + s.lastIndexOf("Java"));
    }
}
