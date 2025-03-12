package advanced1.thread.collection.simple;

import java.util.ArrayList;
import java.util.List;

public class SimpleListMain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // 스레드 1, 스레드 2가 동시에 실행 가졍
        list.add("A"); // 스레드1 실행 가정
        list.add("B"); // 스레드2 실행 가정
        System.out.println(list);
    }
}
