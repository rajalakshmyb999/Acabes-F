package com.main.template.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Template")
public class Template {
    @GetMapping("/hello")
    public String hello(){
        return "New world ";
    }
}
