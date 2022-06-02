package com.example.test.effectivejava.item03;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ElvisOneTest {

    @Test
    @DisplayName("reflection 을 사용하여 private constructor 를 호출할 수 있다.")
    void getInstance()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ElvisOne instance = ElvisOne.INSTANCE;

        // reflection 으로 private constructor 를 무력화한다.
        Constructor<ElvisOne> constructor = ElvisOne.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ElvisOne anotherInstance = constructor.newInstance();

        assertThat(instance).isNotEqualTo(anotherInstance);
    }
}