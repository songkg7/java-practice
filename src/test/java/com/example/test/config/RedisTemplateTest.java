package com.example.test.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedisTemplateTest {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Test
    void testString() {
        // given
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String key = "stringKey";

        // when
        operations.set(key, "hello Redis");

        // then
        String value = operations.get(key);
        assertThat(value).isEqualTo("hello Redis");
    }

    @Test
    void ttl() {
        // given
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        String key = "stringKey";

        // when
        operations.set(key, "hello Redis");
//        operations.set(key, "hello Redis", Duration.ofSeconds(30));

        // ttl(timeToLive) 은 데이터가 들어간 이후에 해야 적용된다. 또는 데이터를 넣는 시점에 적용하면 된다.
        redisTemplate.expire(key, Duration.ofSeconds(30));

        // then
        String value = operations.get(key);
        assertThat(value).isEqualTo("hello Redis");
    }
}