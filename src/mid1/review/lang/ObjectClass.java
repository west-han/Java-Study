package mid1.review.lang;

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
        Map<Integer, Object> objectMap = new HashMap<>(); // {해시코드 : 객체} 형태의 Map 자료형
        int j = 1;

        // int형 범위(21억번) 돌림
        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE + 1L; i++) {
            Object obj = new Object(); // 객체 생성
            int hashCode = obj.hashCode(); // 해시코드 얻기

            // Map에 해당 해시 코드가 존재하는지 확인 (만일 있다면 출력)
            Object obj2 = objectMap.get(hashCode);
            if (obj2 != null) {
                System.out.println((i - Integer.MIN_VALUE + 1L) + "번째 루프");
                System.out.println("새롭게 만든 객체 해시코드 : " + obj.hashCode());
                System.out.println("기존에 있는 객체 해시코드 : " + obj2.hashCode());
                System.out.println("해시코드가 같아도 obj2 == obj 는 : " + (obj2.equals(obj))); // 해시코드가 같아도 객체의 주솟값은 원래 다르니 false 출력
                System.out.println(obj2 == obj);
                System.out.println("");

                if (j >= 4) return; // 4번만 출력
                j++;
            } else {
                objectMap.put(hashCode, obj); // Map에 해시코드와 객체 등록
            }
        }
    }
}
