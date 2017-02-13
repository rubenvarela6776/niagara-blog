package com.codeup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created by rubenvarela on 2/7/17.
 */
@Controller
public class MathController {

    @GetMapping("/{operator}/{a}/and/{b}")
    @ResponseBody
    public String calculate(@PathVariable String operator, @PathVariable("a") int a, @PathVariable("b") int b) {

        int result;
        String noun, verb;

        switch(operator) {
            case "add":
                result = a + b;
                noun = "sum";
                verb = " and ";
                break;
            case "subtract":
                result = a - b;
                noun = "result";
                verb = " minus ";
                break;
            case "multiply":
                result = a * b;
                noun = "product";
                verb = " times ";
                break;
            case "divide":
                result = a / b;
                noun = "result";
                verb = " divided by ";
                break;
            default:
                result = 0;
                noun = "";
                verb = "";
        }

        return "<h1>The " + noun + " of " + a + verb + b + " is " + result + "</h1>";
    }
}