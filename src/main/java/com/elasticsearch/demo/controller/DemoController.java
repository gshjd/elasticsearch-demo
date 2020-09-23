package com.elasticsearch.demo.controller;

import com.elasticsearch.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @PostMapping("demo")
    public boolean demo() {
//        for (int i=0; i<100000000; i++) {
//            new Thread(() -> {
                demoService.demo();
//            });
//        }
        return true;
    }
}
