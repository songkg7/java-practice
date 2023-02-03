package basic.configurationvscomponent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordEncoder {

    public void encode(String password) {
        log.info("PasswordEncoder.encode: {}", password);
    }

}
