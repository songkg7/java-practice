package basic.configurationvscomponent;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class BeanTest {

    @Test
    void getPasswordEncoderBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                SecurityConfig.class);

        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        System.out.println("passwordEncoder.getClass(): " + passwordEncoder.getClass());
        passwordEncoder.encode("password");
    }

    @Test
    void getProxyPasswordEncoderBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SecurityComponent.class);

        PasswordEncoder passwordEncoder = context.getBean(PasswordEncoder.class);
        System.out.println("passwordEncoder.getClass(): " + passwordEncoder.getClass());
        passwordEncoder.encode("password");
    }

}
