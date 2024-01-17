package com.sjiwon.aoptxtest.redis;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SeparateRedisTransactionalComponentA {
    private final StringRedisTemplate stringRedisTemplate;

    public SeparateRedisTransactionalComponentA(@Qualifier("stringRedisTemplateA") final StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Transactional
    public void hello() {
        stringRedisTemplate.opsForValue().set("separate-tx-false-support-1", "success");
        stringRedisTemplate.opsForValue().set("separate-tx-false-support-2", "success");
        stringRedisTemplate.opsForValue().set("separate-tx-false-support-3", "success");
        throw new RuntimeException();
    }
}
