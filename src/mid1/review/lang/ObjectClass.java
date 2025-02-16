package mid1.review.lang;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ObjectClass {
    public static void main(String[] args) {
        Object obj = "getClass() 메서드 결과 확인용";
        Class<?> aClass = obj.getClass();
        System.out.println(aClass);

        Parent parent = new Child();
        System.out.println(parent.getClass());
        System.out.println(obj.hashCode());
        System.out.println(parent.toString());

        findDuplicatedHashCodes();
    }

    static class Parent {}

    static class Child extends Parent {}

    static void findDuplicatedHashCodes() {
        Map<Integer, Object> objectMap = new HashMap<>();
        int j = 1;

        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE + 1L; i++) {
            Object obj = new Object();
            int hashCode = obj.hashCode();

            Object obj2 = objectMap.get(hashCode);
            if (obj2 != null) {
                System.out.println((i - Integer.MIN_VALUE + 1L) + "번째 루프");
                System.out.println("새롭게 만든 객체 해시코드 : " + obj.hashCode());
                System.out.println("기존에 있는 객체 해시코드 : " + obj2.hashCode());
                System.out.println("obj2.equals(obj):" + (obj2.equals(obj)));
                System.out.println("obj2 == obj:" + (obj2 == obj));
                System.out.println();
                if (j >= 10) return;
                j++;
            } else {
                objectMap.put(hashCode, obj);
            }
        }
    }
}
