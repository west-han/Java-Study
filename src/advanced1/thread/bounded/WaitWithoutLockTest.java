package advanced1.thread.bounded;

public class WaitWithoutLockTest {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Counter counter = new Counter(resource);
        Getter getter = new Getter(resource);
        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        t1.start();
        t2.start();
    }

    static class Counter implements Runnable {
        private SharedResource sharedResource;

        public Counter(SharedResource sharedResource) {
            this.sharedResource = sharedResource;
        }

        @Override
        public void run() {
            SharedResource resource = new SharedResource();
            resource.increment();
        }
    }

    static class Getter implements Runnable {
        private SharedResource sharedResource;
        public Getter(SharedResource sharedResource) {
            this.sharedResource = sharedResource;
        }

        @Override
        public void run() {
            sharedResource.get();
        }
    }

    static class SharedResource {
        private int count = 0;

        public void increment() {
            count++;
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public int get() {
            notify();
            return count;
        }
    }
}
