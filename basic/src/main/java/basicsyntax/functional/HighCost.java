package basicsyntax.functional;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class HighCost {

    public static void printIfValidIndex(int index, Supplier<String> supplier) {
        if (index >= 0) {
            System.out.println("the value is " + supplier.get());
        } else {
            System.out.println("Invalid");
        }
    }

    public static String highCostValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Song";
    }

}
