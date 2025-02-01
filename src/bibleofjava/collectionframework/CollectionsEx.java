package bibleofjava.collectionframework;

import java.util.*;

public class CollectionsEx {
    public static void main(String[] args) {
        // Collections: 컬렉션 관련 유용한 메서드 제공
        // Arrays 클래스에 정의되어 있던 fill(), copy(), sort(), binarySearch() 등은 Collections 클래스에도 정의되어 있음

        // 컬렉션 동기화: 기본 동작에 동기화 처리를 적용하면 싱글스레드 환경에서 불필요한 성능 저하가 일어나기 때문에,
        // 필요한 경우 Collections 클래스에 정의된 동기화 메서드를 이용해 동기화 처리가 가능하도록 설계되어 있음
        // synchronizedXXX()
        List<Object> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        SortedMap<Object, Object> synchronizedSortedMap = Collections.synchronizedSortedMap(new TreeMap<>());

        // 불변 컬렉션: unmodifiableXXX()
        List<Object> unmodifiableList = Collections.unmodifiableList(synchronizedList);
        Set<Object> unmodifiableSet = Collections.unmodifiableSet(new HashSet<>());

        // 싱글톤 컬렉션 생성: singletonXXX()
        Set singletonSet = Collections.singleton(new Object());

        // 한 종류의 객체만 저장하는 컬렉션 생성: 두번째 매개변수에 저장할 객체의 클래스 지정 -> 하위 호환성을 위한 메서드, generics 사용 권장
        Collection collection = Collections.checkedCollection(singletonSet, Object.class);
    }
}
