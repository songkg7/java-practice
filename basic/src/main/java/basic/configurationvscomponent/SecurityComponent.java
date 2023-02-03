package basic.configurationvscomponent;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SecurityComponent {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }

    @Bean
    public AspectService aspectService() {
        return new AspectService();
    }

}
