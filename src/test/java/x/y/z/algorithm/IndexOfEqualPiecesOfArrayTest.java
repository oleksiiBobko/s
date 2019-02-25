package x.y.z.algorithm;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class IndexOfEqualPiecesOfArrayTest {

    private static final Logger LOG = LogManager.getLogger(IndexOfEqualPiecesOfArrayTest.class);

    private IndexOfEqualPiecesOfArray indexOfEqualPiecesOfArray = new IndexOfEqualPiecesOfArray();

    @Test
    public void indexOfEqualPiecesOfArrayTest() {

        int[] array = { 1, 2, 3, 6 };

        LOG.info(indexOfEqualPiecesOfArray.findIndex(array));
    }

}
