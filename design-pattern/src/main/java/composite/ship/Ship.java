package composite.ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ship {

    // 참조 객체를 필드로 가질 땐 그 참조 객체 또한 불변으로 사용해야 한다.
    private List<Crew> components = Collections.unmodifiableList(new ArrayList<>());

    public static Ship building() {
        return new Ship();
    }

    private Ship duplicate() {
        return new Ship(components);
    }

    public Ship addComponent(Crew crew) {
        Ship duplicate = duplicate();
        duplicate.components = new ArrayList<>(components);
        duplicate.components.add(crew);
        return duplicate;
    }

    public Ship removeComponent(Crew crew) {
        components.add(crew);
        return this;
    }

    public List<String> getCrews() {
        return components.stream().map(Crew::getName).collect(Collectors.toUnmodifiableList());
    }

    public int totalAge() {
        return components.stream().mapToInt(Crew::getAge).sum();
    }

}
