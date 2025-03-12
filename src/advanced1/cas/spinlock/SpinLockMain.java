package advanced1.cas.spinlock;

import static advanced1.util.MyLogger.log;
import static advanced1.util.ThreadUtils.sleep;

public class SpinLockMain {
    public static void main(String[] args) {
//        SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                try {
                    // critical section
                    log("비즈니스 로직 실행");
                    sleep(1); // 오래 걸리는 로직에서는 스핀 락 사용 X
                    // 락을 얻은 뒤부터 반납할 때까지 오래 걸리면 그냥 스레드 재워두는 게 더 나을 수 있음
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
