package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping(value="testClass")
public class HelloController {

    //Handles request at path /testClass/hello
   @GetMapping("hello")
   //@ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    //lives at /testClass/goodbye
    @GetMapping("goodbye")
    //@ResponseBody
    public String goodBye() {
        return "Goodbye, Spring!";
    }

    //Handles request of the form /testClass/test?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "test")
    //@ResponseBody
    public String testWithQueryParam(String name) {
        return  "Hello, " + name + "!";
    }

    //Handles request of the form /testClass/test/LaunchCode
    @GetMapping("test/{name}")
    //@ResponseBody
    public String testWithPathParam(@PathVariable String name) {
       return "Hello " + name + "!";
    }

    //Handles request of the /testClass/form
    @GetMapping("form")
    //@ResponseBody
    public String form() {
        return "<html>" +
                "<body>" +
                "<p>" +
                "Please enter a name!" +
                "</p>" +
                "<form action='test' method='post'>" + //submit a request to /test
                "<input type='text' name='name'>" +
                "<input type='submit' value='Submit'" +
                "</form>" +
                "</body>" +
                "</html>";
    }

        // responds to /testClass
        @GetMapping("")
        //@ResponseBody
        public String testClass() {
            return "Hello, Richard";
        }

        // responds to /testClass/testMethod
        @GetMapping("testMethod")
        //@ResponseBody
        public String testMethod() {
            return "Hello, Richard";
        }
}
