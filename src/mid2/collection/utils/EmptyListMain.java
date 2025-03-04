package mid2.collection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmptyListMain {
    public static void main(String[] args) {
        // 빈 가변 리스트 생성
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        // 빈 불변 리스트 생성
        List<Object> list3 = Collections.emptyList();
        List<Object> list4 = List.of(); // Java9 이상을 사용한다면 이 방법을 더 권장

        System.out.println("list3.getClass() = " + list3.getClass());
        System.out.println("list4.getClass() = " + list4.getClass());
        // Arrays.asList()의 경우 고정된 크기를 가지지만 요소들은 변경할 수 있는 애매모호한 리스트가 생성된다.

    }
}
