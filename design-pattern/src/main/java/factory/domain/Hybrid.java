package factory.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hybrid implements Car {

    public Hybrid() {
        log.info("create Hybrid.");
    }

    @Override
    public String getName() {
        return "Hybrid";
    }

}
