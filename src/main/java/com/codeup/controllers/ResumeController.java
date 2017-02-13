package com.codeup.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * Created by rubenvarela on 2/8/17.
 */
@Controller
public class ResumeController {
    @GetMapping("/resume")
    public String resumePage() {
        return "resume";
    }
}