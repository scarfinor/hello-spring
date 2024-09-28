package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    //Handles request at path /hello
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

    //Handles request of the form /test?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "test")
    @ResponseBody
    public String testWithQueryParam(String name) {
        return  "Hello, " + name + "!";
    }

    //Handles request of the form /test/LaunchCode
    @GetMapping("test/{name}")
    @ResponseBody
    public String testWithPathParam(@PathVariable String name) {
       return "Hello " + name + "!";
    }

    //Handles request of the /form
    @GetMapping("form")
    @ResponseBody
    public String form() {
       return "<html>" +
               "<body>" +
               "<p>" +
               "Please enter a name!" +
               "</p>"  +
               "<form action='test' method='post'>" + //submit a request to /test
               "<input type='text' name='name'>" +
               "<input type='submit' value='Submit'" +
               "</form>" +
               "</body>" +
               "</html>";
    }


}
