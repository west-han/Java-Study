package mid2.collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class ItemPriceTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);

        map.keySet().stream().filter(key -> map.get(key) == 1000).forEach(System.out::println);
    }
}
