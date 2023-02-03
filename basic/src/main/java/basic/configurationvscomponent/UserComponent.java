package basic.configurationvscomponent;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    public void introduce() {
        System.out.println("hello");
    }

}
