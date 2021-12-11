package com.example.test.effectivejava.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/**
 * Set<String> 인터페이스의 인스턴스를 생성하는데, 정확한 클래스는 명령줄의 첫 번째 인수로 확정한다.
 */
@Slf4j
public final class GenericSetTester {

    public static void test(String[] args) {
        // Convert name to class instance

        Class<? extends Set<String>> clazz = null;
        try {
            clazz = (Class<? extends Set<String>>) Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            fatalError("클래스를 찾을 수 없습니다.");
        }

        // Get constructor
        Constructor<? extends Set<String>> constructor = null;
        try {
            constructor = clazz.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            fatalError("매개변수 없는 생성자를 찾을 수 없습니다.");
        }

        // create set instance
        Set<String> set = null;
        try {
            set = constructor.newInstance();
        } catch (IllegalAccessException e) {
            fatalError("생성자에 접근할 수 없습니다.");
        } catch (InstantiationException e) {
            fatalError("클래스를 인스턴스화 할 수 없습니다.");
        } catch (InvocationTargetException e) {
            fatalError("생성자가 예외를 던졌습니다: " + e.getMessage());
        } catch (ClassCastException e) {
            fatalError("Set 을 구현하지 않은 클래스입나다.");
        }

        // use to created set
        set.addAll(Arrays.asList(args).subList(1, args.length));
        log.info(set.toString());

    }

    private static void fatalError(String message) {
        log.error(message);
        System.exit(1);
    }

}
