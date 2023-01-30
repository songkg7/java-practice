package basic.oop.sea.ship;

import basic.oop.air.AirCraft;
import java.util.ArrayList;
import java.util.List;

public class AirCraftCarrier extends Ship {

    private final List<AirCraft> hangar = new ArrayList<>(30);

    public void loading(AirCraft airCraft) {
        hangar.add(airCraft);
    }
}
