package com.intro.helloWorld.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OurRestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
    @GetMapping("/emir")
    public String emir() {
        return "Emir";
    }

}
