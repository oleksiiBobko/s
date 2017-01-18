package x.y.z.test;

import org.junit.runner.JUnitCore;

public class Main {

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.run(TestCase.class, TestCase2.class);
    }

}
