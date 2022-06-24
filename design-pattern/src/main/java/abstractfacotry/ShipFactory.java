package abstractfacotry;

import abstractfacotry.domain.Ship;

public class ShipFactory {

    public static Ship getShip(Factory<Ship> factory) {
        return factory.build();
    }

}
