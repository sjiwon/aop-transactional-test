package com.sjiwon.aoptxtest.redis;

import org.springframework.stereotype.Service;

@Service
public class HelloRedisService {
    @ExtractCommonLogicRedisTxTypeA
    public void helloTypeA() {
    }

    @ExtractCommonLogicRedisTxTypeB
    public void helloTypeB() {
    }

    @ExtractCommonLogicRedisTxTypeC
    public void helloTypeC() {
    }

    @ExtractCommonLogicRedisTxTypeD
    public void helloTypeD() {
    }
}
