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
    public String testWithQueryParam(@RequestParam String name) {
        return  "Hello, " + name + "!";
    }

    //Handles request of the form /testClass/test2?friend=John&name=Richard
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "test2")
    //@ResponseBody
    public String testWithQueryParam2(@RequestParam String friend, @RequestParam String name) {
        return  "Hello, " + friend + " and " + name + "!";
    }

    //Handles request of the form /testClass/test/Richard/John
    @GetMapping("test/{name}/{friend}")
    //@ResponseBody
    public String testWithPathParam(@PathVariable String name, @PathVariable String friend) {
       return "Hello " + name + " and " + friend + "!";
    }

    //Handles request of the /testClass/form
    @GetMapping("form")
    //@ResponseBody
    public String form() {
        return "<html>" +
                "<body>" +
                "<p>" +
                "Please enter a name & a friend's name!" +
                "</p>" +
                "<form action='test2' method='post'>" + //submit a request to /test2
                "<input type='text' name='name' placeholder='Your Name'>" +
                "<input type='text' name='friend' placeholder='Friend\'s Name'>" +
                "<input type='submit' value='Submit'>" +
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
