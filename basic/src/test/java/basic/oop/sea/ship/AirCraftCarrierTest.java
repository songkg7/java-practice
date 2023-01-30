package basic.oop.sea.ship;

import basic.oop.air.Fighter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AirCraftCarrierTest {

    @Test
    @DisplayName("항공모함은 30대의 항공기를 태울 수 있다.")
    void aircraftCarrierShouldLoad30Aircraft() {
        AirCraftCarrier carrier = new AirCraftCarrier();

        for (int i = 0; i < 30; i++) {
            carrier.loading(new Fighter());
        }
    }

    // 항공모함을 만들다보니 방어력의 개념을 추가하고 싶어진다.
    // armor 라는 필드를 추가하고, damage 를 받을 때 armor 만큼 데미지를 감소시킨다.
    // 이후 이 부분을 데코레이터 패턴을 통해 추상화하면 적절한 디자인 패턴 예제가 될 듯 하다.

}
