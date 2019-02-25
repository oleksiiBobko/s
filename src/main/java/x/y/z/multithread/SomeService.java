package x.y.z.multithread;

import java.util.Random;

public class SomeService {

    public int processValue(int currentValue, int nextValue) {

        try {
            Thread.currentThread().sleep(new Random().nextInt(2));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return currentValue + nextValue;

    }

}
