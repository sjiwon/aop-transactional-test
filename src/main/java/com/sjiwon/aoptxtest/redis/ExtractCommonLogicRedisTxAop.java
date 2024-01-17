package com.sjiwon.aoptxtest.redis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class ExtractCommonLogicRedisTxAop {
    private final StringRedisTemplate stringRedisTemplateA;
    private final StringRedisTemplate stringRedisTemplateB;
    private final SeparateRedisTransactionalComponentA separateRedisTransactionalComponentA;
    private final SeparateRedisTransactionalComponentB separateRedisTransactionalComponentB;

    public ExtractCommonLogicRedisTxAop(
            @Qualifier("stringRedisTemplateA") final StringRedisTemplate stringRedisTemplateA,
            @Qualifier("stringRedisTemplateB") final StringRedisTemplate stringRedisTemplateB,
            final SeparateRedisTransactionalComponentA separateRedisTransactionalComponentA,
            final SeparateRedisTransactionalComponentB separateRedisTransactionalComponentB
    ) {
        this.stringRedisTemplateA = stringRedisTemplateA;
        this.stringRedisTemplateB = stringRedisTemplateB;
        this.separateRedisTransactionalComponentA = separateRedisTransactionalComponentA;
        this.separateRedisTransactionalComponentB = separateRedisTransactionalComponentB;
    }

    @Transactional
    @Around("@annotation(com.sjiwon.aoptxtest.redis.ExtractCommonLogicRedisTxTypeA)")
    public Object handleTypeA(final ProceedingJoinPoint joinPoint) {
        stringRedisTemplateA.opsForValue().set("testA-1", "success");
        stringRedisTemplateA.opsForValue().set("testA-2", "success");
        stringRedisTemplateA.opsForValue().set("testA-3", "success");
        throw new RuntimeException();
    }

    @Transactional
    @Around("@annotation(com.sjiwon.aoptxtest.redis.ExtractCommonLogicRedisTxTypeB)")
    public Object handleTypeB(final ProceedingJoinPoint joinPoint) {
        stringRedisTemplateB.opsForValue().set("testB-1", "success");
        stringRedisTemplateB.opsForValue().set("testB-2", "success");
        stringRedisTemplateB.opsForValue().set("testB-3", "success");
        throw new RuntimeException();
    }

    @Around("@annotation(com.sjiwon.aoptxtest.redis.ExtractCommonLogicRedisTxTypeC)")
    public Object handleTypeC(final ProceedingJoinPoint joinPoint) throws Throwable {
        separateRedisTransactionalComponentA.hello();
        return joinPoint.proceed();
    }

    @Around("@annotation(com.sjiwon.aoptxtest.redis.ExtractCommonLogicRedisTxTypeD)")
    public Object handleTypeD(final ProceedingJoinPoint joinPoint) throws Throwable {
        separateRedisTransactionalComponentB.hello();
        return joinPoint.proceed();
    }
}
