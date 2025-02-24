package mid2.collection.set;

import java.util.Arrays;

public class MyHashSetV0 {
    private int[] elementData = new int[10];
    private int size;

    public boolean add(int value) {
        if (contains(value)) {
            return false;
        }
        elementData[size++] = value;
        return true;
    }

    public boolean contains(int value) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == value) {
                return true;
            }
        }

        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "MyHashSetV0{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }
}
