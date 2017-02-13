package com.codeup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Created by rubenvarela on 2/8/17.
 */
@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "rollDice";
    }

    @GetMapping("/roll-dice/{number}")
    public String rollDicePage(Model model, @PathVariable("number") int number) {
        model.addAttribute("number", number);
        model.addAttribute("randomNumber", (int) Math.floor((Math.random() * 6) + 1));
        return "rollDice";
    }
}