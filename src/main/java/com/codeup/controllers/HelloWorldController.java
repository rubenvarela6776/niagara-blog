package com.codeup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by rubenvarela on 2/7/17.
 */
@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String homePage() {
        return "home";  //home.html
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "<h1>Hello "+ name + " from Spring!!!</h1>";
    }
    @RequestMapping(path = "/bye/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String bye(@PathVariable String name) {
        return "<h1>Goodbye " + name + " from Spring!!!</h1>";
    }

}
