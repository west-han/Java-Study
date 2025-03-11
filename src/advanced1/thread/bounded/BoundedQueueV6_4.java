package advanced1.thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static advanced1.util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {

    private BlockingQueue<String> queue;

    public BoundedQueueV6_4(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }


    @Override
    public void put(String data) {
        boolean result = false;
        result = queue.add(data);
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() {
        return queue.remove();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
