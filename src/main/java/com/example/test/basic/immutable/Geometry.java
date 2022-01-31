package com.example.test.basic.immutable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lombok.Value;

@Value(staticConstructor = "create")
public class Geometry {
    Set<Coordinates> coordinates = new HashSet<>();

    // 객체 참조를 전달하는 메서드는 수정이 불가능한 참조를 전달하도록 해야 불변성을 유지할 수 있다.
    public Set<Coordinates> getCoordinates() {
        return Collections.unmodifiableSet(coordinates);
    }
}
