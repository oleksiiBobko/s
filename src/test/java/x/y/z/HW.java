package x.y.z;

import java.util.Random;

import org.junit.Test;

public class HW {

    @Test
    public void randomString() {
        System.out.println(randomString(-229985452) + " " + randomString(-147909649));
    }

    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }

        return sb.toString();
    }

}
