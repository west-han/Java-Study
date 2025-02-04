package mid1.lang.math.test;

import java.util.Random;

public class LottoGenerator {
    private final Random rand = new Random();
    private int[] lottoNumbers;
    private int count;

    public int[] generate() {
        lottoNumbers = new int[6];
        count = 0;

        while (count < 6) {
            int numGenerated = rand.nextInt(45);
            if (isUnique(numGenerated)) {
                lottoNumbers[count++] = numGenerated + 1;
            }
        }

        return lottoNumbers;
    }

    private boolean isUnique(int numGenerated) {
        for (int i = 0; i < count; i++) {
            if (numGenerated == lottoNumbers[i]) {
                return false;
            }
        }
        return true;
    }
}
