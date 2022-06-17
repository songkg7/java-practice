package effectivejava.item59;

import java.util.Random;

public class OldRandom {

    public static Random rnd = new Random();

    public static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
    }

    public static int staticRandom(int n) {
        return rnd.nextInt(n);
    }

}
