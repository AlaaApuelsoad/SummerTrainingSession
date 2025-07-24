package com.ntg.SpringWeb.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "HelloController";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    public void controller(){
        System.out.println("In controller");
    }
}
