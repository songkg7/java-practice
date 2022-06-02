package com.example.test.effectivejava.item03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Base64;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

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

    @TestFactory
    @DisplayName("직렬화된 싱글턴 객체는 역직렬화될 때 새로 생성되어 서로 다른 객체가 된다.")
    Stream<DynamicTest> serializable() {
        ElvisTwo instance = ElvisTwo.getInstance();

        AtomicReference<String> base64Instance = new AtomicReference<>("");
        Stream<DynamicTest> serializeTest = Stream.of(
                dynamicTest("직렬화", () -> {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(instance);

                    // 직렬화된 객체
                    byte[] serializedInstance = byteArrayOutputStream.toByteArray();
                    base64Instance.set(Base64.getEncoder().encodeToString(serializedInstance));
                    System.out.println(base64Instance.get());
                }));

        Stream<DynamicTest> deserializeTest = Stream.of(
                dynamicTest("역직렬화된 객체는 직렬화한 객체와 같지 않다.", () -> {
                    byte[] serializedInstance = Base64.getDecoder().decode(base64Instance.get());
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                            serializedInstance);
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    Object objectInstance = objectInputStream.readObject();
                    // 역직렬화된 객체
                    ElvisTwo anotherInstance = (ElvisTwo) objectInstance;

                    assertThat(instance).isNotEqualTo(anotherInstance);
                })
        );

        return Stream.concat(serializeTest, deserializeTest);
    }
}