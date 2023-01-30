package basic.oop.sea.ship;

import basic.oop.sea.cargo.Cargo;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ContainerShip extends Ship {

    private final List<Cargo> cargoRoom = new ArrayList<>();

    public void loading(Cargo cargo) {
        cargoRoom.add(cargo);
    }
}
