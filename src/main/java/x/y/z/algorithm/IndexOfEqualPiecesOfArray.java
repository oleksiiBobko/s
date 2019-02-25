package x.y.z.algorithm;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IndexOfEqualPiecesOfArray {

    public int findIndex(int[] array) {
        int sum = IntStream.of(array).sum();

        for (int i = 0; i < array.length; i++) {
            int sumOfPiece = IntStream.of(Arrays.copyOf(array, i)).sum();
            if (sum - sumOfPiece == sumOfPiece) {
                return i;
            }

        }

        return 0;

    }

}
