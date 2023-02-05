package com.example.proxyexample.cglib;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.proxyexample.cglib.mixin.Class1;
import com.example.proxyexample.cglib.mixin.Class2;
import com.example.proxyexample.cglib.mixin.Interface1;
import com.example.proxyexample.cglib.mixin.Interface2;
import com.example.proxyexample.cglib.mixin.MixinInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.Mixin;
import org.junit.jupiter.api.Test;

class CglibTest {

    @Test
    void returning_the_same_value() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((FixedValue) () -> "Hello Tom!");
        PersonService proxy = (PersonService) enhancer.create();

        String res = proxy.sayHello(null);

        assertThat(res).isEqualTo("Hello Tom!");
    }

    @Test
    void returning_value_depending_on_method_signature() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonService.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> {
            if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                return "Hello Tom!";
            } else {
                return proxy.invokeSuper(obj, args);
            }
        });

        PersonService proxy = (PersonService) enhancer.create();

        String res = proxy.sayHello(null);
        assertThat(res).isEqualTo("Hello Tom!");

        int length = proxy.lengthOfName("Mary"); // this method is not intercepted because it returns an int
        assertThat(length).isEqualTo(4);
    }

    @Test
    void beanCreator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        Method setter = myBean.getClass().getMethod("setName", String.class);
        setter.invoke(myBean, "some string value set by a cglib");

        Method getter = myBean.getClass().getMethod("getName");
        String value = (String) getter.invoke(myBean);

        assertThat(value).isEqualTo("some string value set by a cglib");
    }

    @Test
    void mixin() {
        Mixin mixin = Mixin.create(
                new Class[]{ Interface1.class, Interface2.class, MixinInterface.class },
                new Object[]{ new Class1(), new Class2() }
        );
        MixinInterface mixinDelegate = (MixinInterface) mixin;

        assertThat(mixinDelegate.first()).isEqualTo("first behavior");
        assertThat(mixinDelegate.second()).isEqualTo("second behavior");
    }

}
