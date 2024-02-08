package com.example.demo.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String Hello(){
        return "Hello World";
    }
}
