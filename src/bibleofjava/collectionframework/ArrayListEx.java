package bibleofjava.collectionframework;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList(10);
        list1.add(Integer.valueOf(5));
        list1.add(Integer.valueOf(4));
        list1.add(Integer.valueOf(3));
        list1.add(Integer.valueOf(2));
        list1.add(Integer.valueOf(1));
        System.out.println(list1);

        ArrayList list2 = new ArrayList(list1.subList(2, 5));
        System.out.println(list2);

        Collections.sort(list1);
        System.out.println(list1);
        list1.set(1, 100);
        System.out.println(list1);
        for (int i = list2.size() - 1; i > 0 ; i--) {
            if (list1.contains(list2.get(i))) {
                list2.remove(i);
            }
        }
        System.out.println(list2);

    }
}
