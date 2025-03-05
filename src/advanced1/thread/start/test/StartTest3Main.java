package advanced1.thread.start.test;

import static advanced1.util.MyLogger.log;

public class StartTest3Main {
    public static void main(String[] args) {
        Thread threadA = new Thread(new Printer("A", 1000), "Thread-A");
        Thread threadB = new Thread(new Printer("B", 500), "Thread-B");
        threadA.start();
        threadB.start();
    }

    static class Printer implements Runnable {

        private String content;
        private int cycle;

        public Printer(String name, int cycle) {
            this.content = name;
            this.cycle = cycle;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(cycle);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
