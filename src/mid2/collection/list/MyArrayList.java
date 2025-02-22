package mid2.collection.list;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        if (size >= elementData.length) {
            grow();
        }

        elementData[size++] = e;
    }
    @Override
    public void add(int index, E e) {
        if (size >= elementData.length) {
            grow();
        }

        shiftRightFrom(index);
        elementData[index] = e;
        size++;
    }

    @Override
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

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, Object e) {
        E oldValue = (E) elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size)) +
                " size=" + size + ", capacity=" + elementData.length;
    }
}
