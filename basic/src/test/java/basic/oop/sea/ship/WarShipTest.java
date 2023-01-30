package basic.oop.sea.ship;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WarShipTest {

    @Test
    void attack() {
        WarShip warShip = new WarShip(40);
        ContainerShip containerShip = new ContainerShip();

        warShip.sailing();
        containerShip.sailing();

        warShip.attack(containerShip);

        assertThat(containerShip.getDurability()).isEqualTo(60);
    }

    @Test
    @DisplayName("WarShip 은 자기 자신을 공격할 수 없다.")
    void warShipAttackSelf() {
        WarShip warShip = new WarShip();
        assertThatThrownBy(() -> warShip.attack(warShip))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자기 자신을 공격할 수 없습니다.");
    }

}
