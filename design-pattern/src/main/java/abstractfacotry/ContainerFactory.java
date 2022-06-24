package abstractfacotry;

import abstractfacotry.domain.Container;
import abstractfacotry.domain.Ship;

public class ContainerFactory implements Factory<Ship> {

    @Override
    public Ship build() {
        return new Container("Container Sunny");
    }

}
