package bibleofjava.collectionframework;

import java.util.*;

public class MapEx {
    public static void main(String[] args) {
        // HashMap: Entry라는 내부 클래스 정의, Entry 배열을 필드로 선언, 키와 값을 매핑해 하나의 배열로 다룸으로써 데이터 무결성을 보장하기 위함
        Map map = new HashMap();
        map.put("id", "pwd");
        map.put("asdf", "1111");
        map.put("asdf", "1234"); // 값 덮어쓰기
        // hashing 기법으로 키값 비교 시에 hashCode(), equals() 메서드를 모두 사용
        // hashCode() 결과가 같고 equals() 결과가 false인 경우 separate chaining 기법으로 충돌 제어
        // hashCode() 결과가 같고 equals() 결과가 true인 경우 동일한 키로 판단하고 덮어쓰기

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        // TreeMap: BST 형태로 데이터 저장(키값을 비교해서 정렬)
        // 검색 성능은 HashMap이 훨씬 좋지만, 범위검색이나 정렬이 필요한 경우에는 TreeMap을 사용하는 것이 더 유리
        String[] data = {"A", "K", "A", "K", "D", "K", "A", "Z", "D", "C", "A", "K"};
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < data.length; i++) {
            if (treeMap.containsKey(data[i])) {
                Integer value = treeMap.get(data[i]);
                treeMap.put(data[i], value.intValue() + 1);
            } else {
                treeMap.put(data[i], 1);
            }
        }

        Iterator it = treeMap.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            Integer value = (Integer) treeMap.get(key);
            System.out.println(key + "=" + value);
        }



    }
}
