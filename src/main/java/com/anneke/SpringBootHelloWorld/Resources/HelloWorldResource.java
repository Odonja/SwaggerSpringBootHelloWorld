package com.anneke.SpringBootHelloWorld.Resources;

import com.anneke.SpringBootHelloWorld.objects.HelloObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloWorldResource {

    @GetMapping("/helloworld")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/hello/{name}")
    public HelloObject myHello(@PathVariable(value = "name") String name,@RequestBody String message){
        return new HelloObject(name, message);
    }
}
