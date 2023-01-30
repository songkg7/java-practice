package basic.oop.sea.ship;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ShipTest {

    @Test
    @DisplayName("선박의 durability 는 0 이하가 될 수 없다.")
    void durabilityShouldNotBeNegative() {
        // given
        ContainerShip containerShip = new ContainerShip();

        // when 100을 초과하는 피해를 입었을 경우
        containerShip.damage(101);

        // then
        assertThat(containerShip.getDurability()).isEqualTo(0);
    }

    @Test
    @DisplayName("선박의 durability 가 30 이하라면 항해를 지속할 수 없다.")
    void ifDurabilityIsLessThan30ThenCannotSailing() {
        ContainerShip containerShip = new ContainerShip();
        containerShip.damage(70);

        assertThatThrownBy(containerShip::sailing)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("내구도가 30 이하입니다. 항해를 지속할 수 없습니다.");
    }

}
