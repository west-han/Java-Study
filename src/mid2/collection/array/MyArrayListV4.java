package mid2.collection.array;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class MyArrayListV4<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV4() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV4(int capacity) {
        elementData = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void add(E e) {
        if (size >= elementData.length) {
            grow();
        }

        elementData[size++] = e;
    }
    public void add(int index, E e) {
        if (size >= elementData.length) {
            grow();
        }

        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    public E remove(int index) {
        Object retObj = elementData[index];
        shiftLeftFrom(index);
        elementData[--size] = null;
        return (E) retObj;
    }

    private void shiftLeftFrom(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
    }

    private void shiftRightFrom(int index) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
    }

    private void grow() {
        elementData = Arrays.copyOf(elementData, elementData.length * 2);
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public E set(int index, Object e) {
        E oldValue = (E) elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                " size=" + size + ", capacity=" + elementData.length;
    }
}
