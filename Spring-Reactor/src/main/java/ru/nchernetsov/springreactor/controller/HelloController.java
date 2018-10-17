package ru.nchernetsov.springreactor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

//@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, world";
    }

    @GetMapping("/flux")
    public Flux<Integer> flux() {
        return Flux.range(5, 3);
    }

}
