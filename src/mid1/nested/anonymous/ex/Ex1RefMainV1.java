package mid1.nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV1 {

    public static void helloPrint(Process print) {
        System.out.println("프로그램 시작");

        // 코드 블럭 시작
        print.run();
        // 코드 블럭 종료

        System.out.println("프로그램 종료");
    }

    static class Dice implements Process {

        @Override
        public void run() {
            int i = new Random().nextInt();
            System.out.println("주사위 = " + i);
        }
    }

    static class Sum implements Process {

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("i = " + i);
            }
        }
    }

    public static void main(String[] args) {
        helloPrint(new Dice());
        helloPrint(new Sum());
    }
}
