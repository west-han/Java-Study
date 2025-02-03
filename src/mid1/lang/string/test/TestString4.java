package mid1.lang.string.test;

public class TestString4 {
    public static void main(String[] args) {
        String str = "hello.txt";
        int index = str.lastIndexOf(".");
        String filename = str.substring(0, index);
        String extName = str.substring(index);
        System.out.println("filename = " + filename);
        System.out.println("extName = " + extName);
    }
}
