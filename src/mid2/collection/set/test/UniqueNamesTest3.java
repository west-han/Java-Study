package mid2.collection.set.test;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNamesTest3 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        Set treeSet = new TreeSet(List.of(inputArr));
        System.out.println(treeSet);
    }
}
