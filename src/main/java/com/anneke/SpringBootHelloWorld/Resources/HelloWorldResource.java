package com.anneke.SpringBootHelloWorld.Resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class HelloWorldResource {

    @GetMapping("/helloworld")
    public String hello() {
        return "Hello World";
    }
}
