package basic.aop;

import org.springframework.stereotype.Service;

@Service
public class AopService {

    @LogExecutionTime
    public void print() {
        System.out.println("aop test!!!!!!!");
    }
}
