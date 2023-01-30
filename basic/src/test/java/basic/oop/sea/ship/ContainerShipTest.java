package basic.oop.sea.ship;

import static org.assertj.core.api.Assertions.assertThat;

import basic.oop.sea.cargo.Cargo;
import org.junit.jupiter.api.Test;

class ContainerShipTest {

    @Test
    void loading() {
        // given
        ContainerShip containerShip = new ContainerShip();
        Cargo cargo = new Cargo();

        // when
        containerShip.loading(cargo);

        // then
        assertThat(containerShip.getCargoRoom()).contains(cargo);
    }

}
