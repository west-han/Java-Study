package advanced1.thread.start.test;

import static advanced1.util.MyLogger.log;

public class StartTest2Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                log("value: " + (i + 1));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}
