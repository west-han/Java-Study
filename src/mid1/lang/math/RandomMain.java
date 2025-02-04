package mid1.lang.math;

import java.util.Random;

public class RandomMain {
    public static void main(String[] args) {
        Random random = new Random(); // 내부적으로 System.nanoTime() 값에 여러 복잡한 알고리즘을 섞어서 씨드값 생성해 사용
        // Random random = new Random(1); // seed 값이 같으면 Random의 결과는 항상 같음, 테스트 코드에서 유용

        int randInt = random.nextInt();
        System.out.println("randInt = " + randInt);

        double randDouble = random.nextDouble();
        System.out.println("randDouble = " + randDouble);

        boolean randBoolean = random.nextBoolean();
        System.out.println("randBoolean = " + randBoolean);

        // 범위 조회
        int randRange1 = random.nextInt(10);// 0 ~ 9까지 출력
        System.out.println("0 ~ 9 = " + randRange1);

        int randRange2 = random.nextInt(10) + 1;// 1 ~ 10까지 출력
        System.out.println("1 ~ 10 = " + randRange2);
    }
}
