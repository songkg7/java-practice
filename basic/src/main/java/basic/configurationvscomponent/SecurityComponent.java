package basic.configurationvscomponent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
public class SecurityComponent {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }

    // NOTE: Lite mode 로 인해 객체가 다시 한 번 생성되므로 결과적으로 서로 다른 PasswordEncoder 가 생성된다.
    @Bean
    public PasswordEncoder anyPasswordEncoder() {
        return passwordEncoder();
    }

    @Bean
    public AspectService aspectService() {
        return new AspectService();
    }

}
