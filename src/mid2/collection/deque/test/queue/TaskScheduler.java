package mid2.collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class TaskScheduler {
    private static final Deque<Task> tasks = new ArrayDeque<>();
    public void addTask(Task task) {
        tasks.offer(task);
    }

    public int getRemainingTasks() {
        return tasks.size();
    }

    public void processNextTask() {
        Task task = tasks.poll();
        if (task != null) {
            task.execute();
        }
    }
}
