package basic.configurationvscomponent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// NOTE: proxyTargetClass 를 설정하지 않을경우 interface 가 아닌데도 Dynamic proxy 가 사용되며 에러가 발생한다.
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEncoder();
    }

    @Bean
    public PasswordEncoder anyPasswordEncoder() {
        return passwordEncoder();
    }

    @Bean
    public AspectService aspectService() {
        return new AspectService();
    }

}
