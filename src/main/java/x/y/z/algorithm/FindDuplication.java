package x.y.z.algorithm;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class FindDuplication {

    public int findDuplication(int[] array) {
        int max = max(array);

        int sum = ((1 + max) * max) / 2;

        int originalSum = sumArray(array);

        return originalSum - sum;
    }

    private int sumArray(int[] array) {
        return IntStream.of(array).sum();
    }

    public int findDuplicationInSet(int[] array) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if (set.add(array[i])) {
                return array[i];

            }

        }

        return 0;

    }

    private int max(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
}
