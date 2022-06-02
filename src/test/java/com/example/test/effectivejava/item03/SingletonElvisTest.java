package com.example.test.effectivejava.item03;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Base64;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonElvisTest {

    @Test
    @DisplayName("reflection 을 사용하여 private constructor 를 호출할 수 있다.")
    void elvisOne()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ElvisOne instance = ElvisOne.INSTANCE;

        // reflection 으로 private constructor 를 무력화한다.
        Constructor<ElvisOne> constructor = ElvisOne.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ElvisOne anotherInstance = constructor.newInstance();

        assertThat(instance).isNotEqualTo(anotherInstance);
    }

    @Test
    @DisplayName("정적 팩토리를 사용한다해도 reflection 을 회피할 수 없다.")
    void elvisTwo()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ElvisTwo instance = ElvisTwo.getInstance();

        Constructor<ElvisTwo> constructor = ElvisTwo.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ElvisTwo anotherInstance = constructor.newInstance();

        assertThat(instance).isNotEqualTo(anotherInstance);
    }

    @Test
    @DisplayName("직렬화된 싱글턴 객체는 역직렬화될 때 새로 생성되어 서로 다른 객체가 된다.")
    void serializable() throws IOException, ClassNotFoundException {
        ElvisTwo instance = ElvisTwo.getInstance();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(instance);

        // 직렬화된 객체
        byte[] serializedInstance = byteArrayOutputStream.toByteArray();
        String base64Instance = Base64.getEncoder().encodeToString(serializedInstance);
        System.out.println(base64Instance);

        byte[] serializedInstance2 = Base64.getDecoder().decode(base64Instance);
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(serializedInstance2);
        ObjectInputStream objectInputStream2 = new ObjectInputStream(byteArrayInputStream2);
        Object objectInstance = objectInputStream2.readObject();
        // 역직렬화된 객체
        ElvisTwo anotherInstance = (ElvisTwo) objectInstance;

        assertThat(instance).isNotEqualTo(anotherInstance);
    }
}