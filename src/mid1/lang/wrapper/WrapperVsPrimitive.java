package mid1.lang.wrapper;

public class WrapperVsPrimitive {
    public static void main(String[] args) {
        int iterations = 1_000_000_000;
        long startTime, endTime;

        long sumPrimitive = 0L;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumPrimitive += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumPrimitive);
        System.out.println("기본 자료형 long Elapsed time (ms): " + (endTime - startTime));

        Long sumWrapper = 0L;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            sumWrapper += i; // auto boxing
        }
        endTime = System.currentTimeMillis();
        System.out.println("sumWrapper = " + sumWrapper);
        System.out.println("래퍼 클래스 Long Elapsed time (ms): " + (endTime - startTime));

        /*
          메모리 사용량, 연산 시간 모두 Wrapper 객체가 더 크다.
          10억회의 연산 결과가 약 5배 차이로, 일반적인 경우라면 성능을 고려하기보다는 유지보수에 더 좋은 타입을 선택하는 것이 바람직하다.
         */
    }
}
