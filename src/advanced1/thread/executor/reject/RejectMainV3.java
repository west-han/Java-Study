package advanced1.thread.executor.reject;

import advanced1.thread.executor.RunnableTask;

import java.util.concurrent.*;

import static advanced1.util.MyLogger.log;

public class RejectMainV3 {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy()); // AbortPolicy, DiscardPolicy, CallerRunsPolicy

        executor.submit(new RunnableTask("task1"));
        executor.submit(new RunnableTask("task2"));
        executor.submit(new RunnableTask("task3"));
        executor.submit(new RunnableTask("task4"));
        executor.close();
    }
}
