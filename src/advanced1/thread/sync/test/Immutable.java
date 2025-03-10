package advanced1.thread.sync.test;

// Immutable class를 사용하는 경우, 공유자원의 상태를 변경할 수 없으므로 멀티스레드 상황에서 문제가 발생하지 않음
public class Immutable {
    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
