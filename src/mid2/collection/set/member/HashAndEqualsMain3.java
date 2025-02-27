package mid2.collection.set.member;

import mid2.collection.set.MyHashSetV2;

public class HashAndEqualsMain3 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        Member m1 = new Member("A");
        Member m2 = new Member("A");
        System.out.println("m1.hashCode() = " + m1.hashCode());
        System.out.println("m2.hashCode() = " + m2.hashCode());
        System.out.println("m1.equals(m2) = " + m1.equals(m2));

        set.add(m1);
        set.add(m2);
        System.out.println(set);

        // 검색 실패
        Member searchValue = new Member("A");
        System.out.println("searchValue.hashCode() = " + searchValue.hashCode());
        boolean contains = set.contains(searchValue);
        System.out.println("contains = " + contains);

        // 해시코드는 충돌 가능
        // HashSet에서는 먼저 hashCode()를 이용해 인덱스를 구한 뒤 실제 객체 비교는 equals() 이용하므로 문제 없이 동작
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
    }
}