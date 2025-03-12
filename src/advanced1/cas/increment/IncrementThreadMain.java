package advanced1.cas.increment;

import java.util.ArrayList;
import java.util.List;

import static advanced1.util.ThreadUtils.sleep;

public class IncrementThreadMain {
    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger) throws InterruptedException {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                sleep(10);
                incrementInteger.increment();
            }
        };

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads.get(i).join();
        }

        int result = incrementInteger.get();
        System.out.println(incrementInteger.getClass().getSimpleName() + " result: " + result);
    }
}
