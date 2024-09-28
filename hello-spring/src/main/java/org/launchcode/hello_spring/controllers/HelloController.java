package org.launchcode.hello_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {
    //handle request at path http://localhost:8080/hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //handle request at path //http://localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
   // public String bonjourWithQueryParam(@RequestParam String name){
     //   return "Bonjour, " + name + "!";
    //}

    @PostMapping
    public String helloPost(@RequestParam(required = false) String name, @RequestParam String language) {
        if (name == null || name.trim().isEmpty()) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        switch (l.toLowerCase()) {
            case "english":
                greeting = "Hello";
                break;
            case "french":
                greeting = "Bonjour";
                break;
            case "italian":
                greeting = "Buongiorno";
                break;
            case "spanish":
                greeting = "Hola";
                break;
            case "german":
                greeting = "Hallo";
                break;
            default:
                greeting = "Hello"; // Default fallback
                break;
        }

        return "<html><body><h1>" + greeting + ", " + n + "!</h1></body></html>";
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "<html><body><h1>Hello, " + name + "!</h1></body></html>";
   }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<h2>Greet Someone!</h2>" +
                "<form action='/hello' method='post'>" +
                "<input type='text' name='name' placeholder='Enter your name'>" +
                "<label for='language-select'>Choose a language:</label>" +
                "<select name='language' id='language-select'>" +
                "<option value=''>--Please choose an option--</option>" +
                "<option value='french'>French</option>" +
                "<option value='english'>English</option>" +
                "<option value='german'>German</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}