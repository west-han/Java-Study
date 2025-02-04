package mid1.lang.system;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SystemMain {
    public static void main(String[] args) {
        // System.in, System.out, System.err: 표준 입력/출력/오류 스트림

        // 현재 시간(밀리초)를 가져온다.
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        // 현재 시간(나노초)를 가져온다.
        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano);

        // 환경변수를 읽는다. (OS 시스템 환경변수)
        System.out.println("getenv = " + System.getenv());

        // 시스템 속성을 읽는다. (시스템 속성은 Java에서 사용하는 설정값)
        System.out.println("properties = " + System.getProperties());
        System.out.println("Java Version = " + System.getProperty("java.version"));

        // 배열을 고속으로 복사한다. (반복문을 도는 것보다 훨씬 빠르지만 shallow copy)
        char[] originalArray = new char[] {'h', 'e', 'l', 'l', 'o'};
        char[] copiedArray = new char[5];
        System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);

        // 배열 출력
        System.out.println("copiedArray = " + copiedArray);
        System.out.println("Arrays.toString(copiedArray) = " + Arrays.toString(copiedArray));;

        System.exit(0);
    }
}
