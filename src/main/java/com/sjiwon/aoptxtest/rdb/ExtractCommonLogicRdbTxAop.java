package com.sjiwon.aoptxtest.rdb;

import com.sjiwon.aoptxtest.domain.Member;
import com.sjiwon.aoptxtest.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@RequiredArgsConstructor
public class ExtractCommonLogicRdbTxAop {
    private final MemberRepository memberRepository;
    private final SeparateRdbTransactionalComponent separateRdbTransactionalComponent;

    @Transactional
    @Around("@annotation(com.sjiwon.aoptxtest.rdb.ExtractCommonLogicRdbTxTypeA)")
    public Object handleTypeA(final ProceedingJoinPoint joinPoint) {
        memberRepository.save(new Member("테스트 계정1"));
        memberRepository.save(new Member("테스트 계정2"));
        memberRepository.save(new Member("테스트 계정3"));
        throw new RuntimeException();
    }

    @Around("@annotation(com.sjiwon.aoptxtest.rdb.ExtractCommonLogicRdbTxTypeB)")
    public Object handleTypeB(final ProceedingJoinPoint joinPoint) throws Throwable {
        separateRdbTransactionalComponent.hello();
        return joinPoint.proceed();
    }
}
