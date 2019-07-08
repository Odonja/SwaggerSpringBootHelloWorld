package com.anneke.SpringBootHelloWorld.objects;

public class HelloObject {

    private final String name;
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
