package advanced2.annotation.java;

public class DeprecatedMain {
    public static void main(String[] args) {
        System.out.println("DeprecatedMain.main");
        DeprecatedClass dc = new DeprecatedClass();
        dc.call1();
        dc.call1(); // IDE 경고
        dc.call3(); // IDE 경고(심각)
    }
}
