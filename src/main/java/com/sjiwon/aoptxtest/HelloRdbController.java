package com.sjiwon.aoptxtest;

import com.sjiwon.aoptxtest.rdb.HelloRdbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloRdbController {
    private final HelloRdbService helloRdbService;

    @PostMapping("/rdb/type-a")
    public ResponseEntity<Void> rdbHelloA() {
        helloRdbService.helloTypeA();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/rdb/type-b")
    public ResponseEntity<Void> rdbHelloB() {
        helloRdbService.helloTypeB();
        return ResponseEntity.ok().build();
    }
}
