package com.codeup.controllers;
import org.codehaus.groovy.transform.GroovyASTTransformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by rubenvarela on 2/7/17.
 */
@Controller
public class HelloWorldController {

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("date", "Feb 7th");
        List<String> names = new ArrayList<>();
        names.add("Ruben");
        names.add("Yassine");
        names.add("Abdou");
        names.add("Fred");
        model.addAttribute("names", names);
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