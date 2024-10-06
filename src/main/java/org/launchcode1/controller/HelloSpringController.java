package org.launchcode1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloSpringController {
    //handle request at path http://localhost:8080/hello

   @RequestMapping (value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
   public String hello(@RequestParam String name, Model model) {
       String greeting = "Hello, " + name + "!";
       model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgian(@PathVariable String name, Model model) {
       String greeting = "Hello, " + name + "!";
       model.addAttribute("greeting", greeting);
       return "hello";
    }

    //handle request at path //http://localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    // public String bonjourWithQueryParam(@RequestParam String name){
    //   return "Bonjour, " + name + "!";
    //}

    @PostMapping
    @ResponseBody
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
        return "form";
    }

    @GetMapping ("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("LaunchCode");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}