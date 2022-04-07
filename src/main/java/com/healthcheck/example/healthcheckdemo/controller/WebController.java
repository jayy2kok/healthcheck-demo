package com.healthcheck.example.healthcheckdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class WebController {

    @RequestMapping("/hi")
    private Mono<String> test() {
        return Mono.just("hi");
    }
}
