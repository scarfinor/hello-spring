package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    //Handeles request at path /hello
   @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodBye() {
        return "Goodbye, Spring!";
    }

    //Handles request of the form /hello?name=LaunchCode
    @GetMapping("test")
    @ResponseBody
    public String helloWithQueryParam(String name[]
    ) {
        return  "hello, " + name + "!";
    }
}
