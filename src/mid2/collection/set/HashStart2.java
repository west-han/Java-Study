package mid2.collection.set;

import java.util.Arrays;

public class HashStart2 {
    public static void main(String[] args) {
        Integer[] inputArray = new Integer[10];
        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        int searchValue = 8;
        // 4번 반복 O(n)
        Integer result = inputArray[searchValue];
        System.out.println("result = " + result);
    }
}
