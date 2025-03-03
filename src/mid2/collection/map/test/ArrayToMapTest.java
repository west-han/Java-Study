package mid2.collection.map.test;

import java.util.HashMap;
import java.util.Set;

public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};

        // 주어진 배열로부터 Map 생성
        HashMap<String, Integer> productMap = new HashMap<>();
        for (String[] strings : productArr) {
            productMap.put(strings[0], Integer.valueOf(strings[1]));
        }

        // Map의 모든 데이터 출력
        for (String key : productMap.keySet()) {
            System.out.println("제품: " + key + ", 가격: " + productMap.get(key));
        }
    }
}
