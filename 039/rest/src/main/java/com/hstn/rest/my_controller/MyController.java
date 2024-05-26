package com.hstn.rest.my_controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {

    @GetMapping("/hello")
    public String sayHello(){

        return "Hello World";
    }

}
