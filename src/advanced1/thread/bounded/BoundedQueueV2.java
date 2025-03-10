package advanced1.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static advanced1.util.MyLogger.log;
import static advanced1.util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue {

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {

        while (queue.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            sleep(1000);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[take] 큐에 데이터가 없음, 소비자 대기");
            sleep(1000);
        }

        return queue.poll();
    }

    @Override
    public String toString() { // 원칙적으로는 동기화 처리가 필요하지만, 예제에서는 편의를 위해 생략
        return queue.toString();
    }
}
