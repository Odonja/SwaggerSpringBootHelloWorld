package com.anneke.SpringBootHelloWorld.objects;

import io.swagger.annotations.ApiModelProperty;

public class HelloObject {

    @ApiModelProperty(notes = "name in path")
    private final String name;
    @ApiModelProperty(notes = "posted message")
    private final String message;

    public HelloObject(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

}
