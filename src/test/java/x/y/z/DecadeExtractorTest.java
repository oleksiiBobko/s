package x.y.z;

import java.util.Arrays;

import org.junit.Test;

public class DecadeExtractorTest {

    @Test
    public void numberExtractTest() {
        
        int[] codes = {100, 101, 200, 201, 300, 333, 400, 199};

        Arrays.stream(codes)
            .mapToObj(this::getSubtopicFieldNumber)
            .forEach(s -> System.out.println(s));

    }

    private String getSubtopicFieldNumber(int fieldNumber) {
        int dec = fieldNumber % 100;
        if (dec == 0) {
            return "100";
        } else {
            return String.valueOf(dec);
        }
    }

}
