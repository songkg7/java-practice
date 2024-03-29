package basic.configurationvscomponent;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class BeanTest {

    @Test
    void getPasswordEncoderBean() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SecurityConfig.class);

        PasswordEncoder passwordEncoder = context.getBean("passwordEncoder", PasswordEncoder.class);
        PasswordEncoder anyPasswordEncoder = context.getBean("anyPasswordEncoder", PasswordEncoder.class);
        System.out.println("passwordEncoder.getClass(): " + passwordEncoder.getClass());
        System.out.println("anyPasswordEncoder.getClass(): " + anyPasswordEncoder.getClass());
        passwordEncoder.encode("password");

        assertThat(passwordEncoder).isSameAs(anyPasswordEncoder);
    }

    @Test
    void component() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SecurityComponent.class);

        PasswordEncoder passwordEncoder = context.getBean("passwordEncoder", PasswordEncoder.class);
        PasswordEncoder anyPasswordEncoder = context.getBean("anyPasswordEncoder", PasswordEncoder.class);
        System.out.println("passwordEncoder.getClass(): " + passwordEncoder.getClass());
        System.out.println("anyPasswordEncoder.getClass(): " + anyPasswordEncoder.getClass());

        assertThat(passwordEncoder).isNotSameAs(anyPasswordEncoder);
    }

    @Test
    void proxyFactory() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new PasswordEncoder());
        PasswordEncoder proxy = (PasswordEncoder) proxyFactory.getProxy();
        System.out.println("proxy.getClass(): " + proxy.getClass());
        proxy.encode("password");
    }

    @Test
    void userComponent() {
        ApplicationContext context = new AnnotationConfigApplicationContext(
                UserComponent.class);

        UserComponent userComponent = (UserComponent) context.getBean("userComponent");
        System.out.println("userComponent.getClass(): " + userComponent.getClass());
        userComponent.introduce();
    }

}
