package mid2.collection.list.test.ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            try {
                int input = sc.nextInt();
                if (input == 0) {
                    break;
                }
                list.add(input);
            } catch (NumberFormatException e) {
                System.out.println("정수만 입력 가능");
            }
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        double average = (double) sum / list.size();
        System.out.println("입력한 정수의 합계: " + sum);
        System.out.println("입력한 정수의 평균: " + average);
    }
}
