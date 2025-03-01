package mid2.collection.set.test;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UniqueNamesTest2 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        Set linkedHashSet = new LinkedHashSet<>(List.of(inputArr));
        System.out.println(linkedHashSet);
    }
}
