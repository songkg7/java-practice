package composite.ship.leaf;

import composite.ship.Crew;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Sailor implements Crew {

    private String name;
    private int age;

}
