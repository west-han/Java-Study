package advanced1.thread.executor.poolsize;

import advanced1.thread.executor.RunnableTask;

import java.util.concurrent.*;

import static advanced1.thread.executor.ExecutorUtils.printState;
import static advanced1.util.MyLogger.log;
import static advanced1.util.ThreadUtils.sleep;

public class PoolSizeMainV3 {

    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

        log("pool 생성");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String taskName = "task" + i;
            es.execute(new RunnableTask(taskName));
            printState(es, taskName);
        }

        sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        sleep(3000);
        log("== maximumPoolSize 대기 시간 초과");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
        printState(es);
    }
}
