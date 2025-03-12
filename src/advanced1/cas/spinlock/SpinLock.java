package advanced1.cas.spinlock;

import java.util.concurrent.atomic.AtomicBoolean;

import static advanced1.util.MyLogger.log;
import static advanced1.util.ThreadUtils.sleep;

// Spin Lock: 스레드를 대기시키지 않고 lock을 만드는 것
public class SpinLock {
    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        log("락 획득 시도");
        boolean result = false;

        while (!lock.compareAndSet(false, true)) {
            log("락 획득 실패 - 스핀 대기");
        }

        log("락 획득 완료");
    }

    public void unlock() {
        lock.set(false);
        log("락 반납 완료");
    }
}
