package com.sjiwon.aoptxtest;

import com.sjiwon.aoptxtest.redis.HelloRedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloRedisController {
    private final HelloRedisService helloRedisService;

    @PostMapping("/redis/type-a")
    public ResponseEntity<Void> redisHelloA() {
        helloRedisService.helloTypeA();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/redis/type-b")
    public ResponseEntity<Void> redisHelloB() {
        helloRedisService.helloTypeB();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/redis/type-c")
    public ResponseEntity<Void> redisHelloC() {
        helloRedisService.helloTypeC();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/redis/type-d")
    public ResponseEntity<Void> redisHelloD() {
        helloRedisService.helloTypeD();
        return ResponseEntity.ok().build();
    }
}
