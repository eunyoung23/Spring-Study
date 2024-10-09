package com.example.filterInterceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @GetMapping("/test")
    public void test(){
        System.out.println("필터 테스트");
    }
}
