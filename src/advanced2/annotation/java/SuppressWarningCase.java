package advanced2.annotation.java;

import java.util.ArrayList;
import java.util.List;

public class SuppressWarningCase {

    public void unusedWarning() {
        int unusedVariable = 10;
    }


    public void uncheckedCast() {
        // 제네릭 타입 캐스팅 경고 억제, raw type 사용 경고
        List list = new ArrayList();

        // 제네릭 타입과 관련된 unchecked 경고
        List<String> stringList = list;
    }

    public void suppressAllWarning() {
        // 모든 경고 억제

    }
}
