package bibleofjava.collectionframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysEx {
    public static void main(String[] args) {
        // Arrays 클래스는 배열을 다루는데 유용한 메서드들이 정의된 클래스
        // 배열 복사
        int[] original = {1, 3, 5, -7, 9, -2, 4, -6, 8, 0};
        int[] arr0 = Arrays.copyOf(original, 5);
        int[] arr1 = Arrays.copyOfRange(original, 2, 5);
        System.out.println(Arrays.toString(arr0));
        System.out.println(Arrays.toString(arr1));

        // 배열 채우기
        int[] emptyArr = new int[10];
        Arrays.fill(emptyArr, 1);
        System.out.println(Arrays.toString(emptyArr));
        Arrays.setAll(emptyArr, element -> element + 1);
        System.out.println(Arrays.toString(emptyArr));

        // 정렬, 검색
        Arrays.sort(original);
        System.out.println(Arrays.toString(original));
        int found = Arrays.binarySearch(original, 4); // 반드시 정렬한 뒤에 사용, 내부적으로 정렬해주지 않음
        System.out.println("index: " + found + ", value: " + original[found]);

        // 문자열 비교, 출력
        int[][] arr2D = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        int[][] arr2D2 = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        System.out.println(Arrays.toString(arr2D));
        System.out.println(Arrays.deepToString(arr2D)); // 재귀적 접근
        System.out.println(Arrays.equals(arr2D, arr2D2)); // 일차원 배열들의 주소 비교
        System.out.println(Arrays.deepEquals(arr2D, arr2D2)); // 재귀적으로 각 요소들의 실제 값 비교

        // List로 변환: fixed-size
        List<Integer> list = Arrays.asList(new Integer[]{1, 2, 3, 4, 5});
        new ArrayList<>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5})); // 크기 변경 가능

        // parallelXXX(): 여러 쓰레드가 작업을 나눠서 처리
        // spliterator(): 하나의 작업을 여러 작업으로 나누는 Spliterator 반환
        // stream(): 컬렉션을 스트림으로 변환
    }
}
