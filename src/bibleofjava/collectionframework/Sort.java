package bibleofjava.collectionframework;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
    public static void main(String[] args) {
        // Comparable, Comparator 인터페이스: 컬렉션 정렬을 위한 메서드 선언
        // Comparable: 기본 정렬 기준 구현하는데 사용
        // Comparator: 기본 정렬 기준 외에 다른 기준으로 정렬하고자 할 때 사용
        String[] strArr = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분 없이 오름차순
        System.out.println(Arrays.toString(strArr));
        Arrays.sort(strArr, new Descending()); // 역순 정렬
        System.out.println(Arrays.toString(strArr));
    }
}

class Descending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable c1 && o2 instanceof Comparable c2) {
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
}
