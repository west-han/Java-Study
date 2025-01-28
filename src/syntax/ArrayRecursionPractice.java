package syntax;

public class ArrayRecursionPractice {
    public static void main(String[] args) {
        final int SIZE = 5;

        int[][] arr = new int[SIZE][SIZE];
        int num = 0;

/*
        // 교차
        boolean isIncrease = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isIncrease) {
                    arr[i][j] = ++num;
                } else {
                    arr[i][j] = num--;
                }
            }
            num += 5;
            isIncrease = !isIncrease;
        }
*/

        // 달팽이
        boolean isDirectionX = true;
        int step = 1;
        int x = -1, y = 0;
        for (int length = SIZE * 2 - 1; length > 0; length -= 2) {
            for (int j = 0; j < length; j++) {
                if (j < length / 2 + 1) { // 4까지
                    x += step;
                } else {
                    y += step;
                }
                arr[y][x] =  ++num;
            }
            step *= -1;
        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        String hello = "Hello!!";
        reverse(hello, 0);
    }

    public static void reverse(String str, int index) {
        if (index >= str.length()) {
            return;
        }
        reverse(str, index + 1);
        System.out.print(str.charAt(index));
    }
}
