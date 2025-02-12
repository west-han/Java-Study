package mid1.nested.test;

public class AnonymousMain {
    public static void main(String[] args) {
        new Hello() {

            @Override
            public void hello() {
                System.out.println("AnonymousMain.hello");
            }
        }.hello();
    }
}
