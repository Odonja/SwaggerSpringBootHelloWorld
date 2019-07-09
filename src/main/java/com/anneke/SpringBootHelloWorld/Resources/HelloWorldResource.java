package com.anneke.SpringBootHelloWorld.Resources;

import com.anneke.SpringBootHelloWorld.objects.HelloObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/rest", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "HelloWorld Resource")
public class HelloWorldResource {

    @ApiOperation(value = "Returns Hello World")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )
    @GetMapping("/helloworld")
    public String hello() {
        return "Hello World";
    }

    @ApiOperation(value = "Returns Hello world object with name and message")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )
    @PostMapping("/hello/{name}")
    public HelloObject myHello(@PathVariable(value = "name") final String name,@RequestBody final String message){
        return new HelloObject(name, message);
    }
}
