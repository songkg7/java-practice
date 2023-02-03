package basic.configurationvscomponent;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectService {

    @Around("execution(* basic.configurationvscomponent.PasswordEncoder.encode(..))")
    public Object log(ProceedingJoinPoint pjp) {
        System.out.println("AspectService.log");
        return null;
    }

}
