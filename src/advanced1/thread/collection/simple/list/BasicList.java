package advanced1.thread.collection.simple.list;

import java.util.Arrays;

import static advanced1.util.ThreadUtils.sleep;

public class BasicList implements SimpleList {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object e) {
        elements[size] = e;
        sleep(100); // 멀티스레드 문제를 쉽게 확인하기 위한 코드
        size++;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size)) + " size=" + size + ", capacity=" + elements.length;
    }
}
