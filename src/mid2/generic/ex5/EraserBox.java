package mid2.generic.ex5;

public class EraserBox<T> {
    public boolean instanceCheck(Object param) {
//        return param instanceof T: // 오류
        return true;
    }

    public void create() {
//        T t = new T(); // 오류
    }
}
