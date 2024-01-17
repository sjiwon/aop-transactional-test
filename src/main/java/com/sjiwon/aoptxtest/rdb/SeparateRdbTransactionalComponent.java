package com.sjiwon.aoptxtest.rdb;

import com.sjiwon.aoptxtest.domain.Member;
import com.sjiwon.aoptxtest.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SeparateRdbTransactionalComponent {
    private final MemberRepository memberRepository;

    @Transactional
    public void hello() {
        memberRepository.save(new Member("테스트 계정1"));
        memberRepository.save(new Member("테스트 계정2"));
        memberRepository.save(new Member("테스트 계정3"));
        throw new RuntimeException();
    }
}
