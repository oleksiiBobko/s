package x.y.z.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class FindDuplicationTest {

    private static final Logger LOG = LogManager.getLogger(FindDuplicationTest.class);

    FindDuplication findDuplication = new FindDuplication();

    @Test
    public void findDuplicationTest() {

        int[] array = { 1, 2, 3, 4, 15, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
//        int[] array = {1};

        LOG.info(findDuplication.findDuplication(array));

    }

}
