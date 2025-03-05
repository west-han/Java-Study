package advanced1.thread.start.test;

import static advanced1.util.MyLogger.*;

public class StartTest1Main {
    public static void main(String[] args) {
        new CounterThread().start();
    }

    static class CounterThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log("value: " + (i+1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
