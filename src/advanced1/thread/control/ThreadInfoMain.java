package advanced1.thread.control;

import advanced1.thread.start.HelloRunnable;

import static advanced1.util.MyLogger.log;

public class ThreadInfoMain {

    public static void main(String[] args) {
        // main 스레드
        Thread mainThread = Thread.currentThread();
        System.out.println("mainThread = " + mainThread);
        System.out.println("mainThread.threadId() = " + mainThread.threadId());
        System.out.println("mainThread.getName() = " + mainThread.getName());
        System.out.println("mainThread.getPriority() = " + mainThread.getPriority()); // 1~10 (기본값 5)
        System.out.println("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
        System.out.println("mainThread.getState() = " + mainThread.getState());

        // myThread 스레드
        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        System.out.println("myThread = " + myThread);
        System.out.println("myThread.threadId() = " + myThread.threadId());
        System.out.println("myThread.getName() = " + myThread.getName());
        System.out.println("myThread.getPriority() = " + myThread.getPriority());
        System.out.println("myThread.getThreadGroup() = " + myThread.getThreadGroup());
        System.out.println("myThread.getState() = " + myThread.getState());
    }
}
