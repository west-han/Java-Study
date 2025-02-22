package mid2.collection.list;

public class BatchProcessMain {
    public static void main(String[] args) {
        BatchProcessor batch1 = new BatchProcessor(new MyArrayList<>());
        BatchProcessor batch2 = new BatchProcessor(new MyLinkedList<>());

        final int SIZE = 50_000;

        batch1.logic(SIZE);
        System.out.println();
        batch2.logic(SIZE);
    }
}
