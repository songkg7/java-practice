package com.example.javapractice.basic.immutable;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GeometryTest {

    @Test
    @DisplayName("불변 객체는 내부 모든 필드가 불변성을 보장해야한다.")
    void test_1() {
        Set<Coordinates> coordinates = Geometry.create().getCoordinates();
        System.out.println("coordinates = " + coordinates);

        // get method 가 수정할 수 없는 객체의 참조를 전달하므로 set 에 새로운 값을 추가할 수 없다.
        assertThrows(UnsupportedOperationException.class, () -> coordinates.add(Coordinates.of(0, 0)));
    }
}