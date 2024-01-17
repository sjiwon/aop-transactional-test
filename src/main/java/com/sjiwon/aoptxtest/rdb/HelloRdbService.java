package com.sjiwon.aoptxtest.rdb;

import org.springframework.stereotype.Service;

@Service
public class HelloRdbService {
    @ExtractCommonLogicRdbTxTypeA
    public void helloTypeA() {
    }

    @ExtractCommonLogicRdbTxTypeB
    public void helloTypeB() {
    }
}
