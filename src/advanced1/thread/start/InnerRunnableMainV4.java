package advanced1.thread.start;

import static advanced1.util.MyLogger.log;

public class InnerRunnableMainV4 {
    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(() -> log("run()"));
        thread.start();

        log("main() end");
    }
}
