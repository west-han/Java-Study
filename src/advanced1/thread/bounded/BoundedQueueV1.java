package advanced1.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static advanced1.util.MyLogger.log;

public class BoundedQueueV1 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if (queue.size() == max) {
            log("[put] 큐가 가득 참, 버림 " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }

    @Override
    public String toString() { // 원칙적으로는 동기화 처리가 필요하지만, 예제에서는 편의를 위해 생략
        return queue.toString();
    }
}
