package bibleofjava.collectionframework;

import java.util.*;

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name=" + name + "/age=" + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person person) {
            return this.name.equals(person.name) && this.age == person.age;
        }
        return false;
    }

    /*
     - hashCode() 메서드의 조건
       1. 동일한 객체에 대해 여러번 hashCode()를 호출해도 항상 동일한 int값 반환
       2. equals 메서드를 호출했을 때 true를 반환하는 두 객체에 대해 hashCode()를 호출한 결과는 반드시 같아야 한다.
       3. equals 메서드를 호출했을 때 false를 반환하는 두 객체는 hashCode()의 호출 결과가 다를도록 구현하면 hashing을 사용하는 컬렉션의 성능에 더 유리하다.
          -> hashing을 이용하는 컬렉션은 객체의 비굘르 위해 equals(), hashCode()를 모두 호출하므로 반드시 같을 필요는 없으나,
             hashing 기법의 특성 상 Collision 발생이 잦을수록 성능이 떨어질 수밖에 없기 때문
             참고: Java의 컬렉션 프레임워크는 충돌 해결을 위해 separate chaining 기법 사용
     */
    @Override
    public int hashCode() {
//        return (name+age).hashCode();
        return Objects.hash(name, age);
    }
}

public class SetEx {
    public static void main(String[] args) {
        Person p1 = new Person("han", 28);
        Person p2 = new Person("han", 28);

        Set set = new HashSet();
        set.add("Test");
        set.add("Test");
        set.add(p1);
        set.add(p2);
        // HashSet은 중복 검사를 위해 equals(), hashCode()를 모두 호출하므로 둘 중 하나라도 재정의하지 않으면 p1, p2를 서로 다른 객체로 취급
        System.out.println(set);

        // TreeSet: BST, 구체적으로는 Red-Black Tree를 이용해 구현한 Set, 자동 정렬
        TreeSet treeSet = new TreeSet();
        treeSet.add("B");
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("g");
        treeSet.add("f");
        treeSet.add("c");
        treeSet.add("j");
        System.out.println(treeSet);
        System.out.println(treeSet.headSet("d"));
        System.out.println(treeSet.tailSet("d"));
        Comparator comparator = treeSet.comparator();
        System.out.println(treeSet.ceiling("c"));
        System.out.println(treeSet.ceiling("d"));
    }
}
