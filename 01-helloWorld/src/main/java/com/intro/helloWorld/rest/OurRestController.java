package com.intro.helloWorld.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OurRestController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }
    @GetMapping("/${name}")
    public String emir() {
        return "Emir";
    }

    @GetMapping("yilmaz")
    public String yilmaz() {
        return "Yilmaz";
    }

    @GetMapping("devtools")
    public String devToools(){
        return "Dev Toools";
    }

}
