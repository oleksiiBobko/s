package x.y.z.springtest;

import org.junit.runner.JUnitCore;

public class Main {

    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.run(TestCase.class);

    }

}
