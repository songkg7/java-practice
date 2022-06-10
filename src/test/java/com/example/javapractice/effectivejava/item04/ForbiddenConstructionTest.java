package com.example.javapractice.effectivejava.item04;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ForbiddenConstructionTest {

    @Test
    @DisplayName("private constructor 에 예외를 던지도록 구현하면 reflection 을 통한 공격도 막을 수 있다.")
    void reflection() throws NoSuchMethodException {
        Constructor<ForbiddenConstruction> constructor = ForbiddenConstruction.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        // UnsupportedOperationException 이 발생하지만 reflection 도중 발생하므로 InvocationTargetException 으로 감싸진다.
        assertThatThrownBy(constructor::newInstance).isInstanceOf(InvocationTargetException.class);
    }
}