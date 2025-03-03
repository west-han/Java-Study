package mid2.collection.iterable;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class MyArray implements Iterable<Integer> {

    private int[] numbers;

    public MyArray(int[] numbers) {
        this.numbers = numbers;
    }

    @NotNull
    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(numbers);
    }
}
