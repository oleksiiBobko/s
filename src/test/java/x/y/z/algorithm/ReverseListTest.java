package x.y.z.algorithm;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class ReverseListTest {

    private static final Logger LOG = LogManager.getLogger(ReverseListTest.class);
    
    private ReverseList<String> reverseList;

    @Test
    public void reverseListTest() {
        reverseList = new ReverseList<String>();
        List<String> inputList = new LinkedList<>();
        inputList.add("1");
        inputList.add("2");
        inputList.add("3");
        inputList.add("4");
        inputList.add("5");

        List<String> list = reverseList.reverseList(inputList);

        LOG.info(list.toString());

    }

}
