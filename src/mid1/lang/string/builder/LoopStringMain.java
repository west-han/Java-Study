package mid1.lang.string.builder;

public class LoopStringMain {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 100000; i++) {
            result += "Hello Java ";
        }
        long end = System.currentTimeMillis();

        System.out.println("end - start = " + (end - start));


    }
}
