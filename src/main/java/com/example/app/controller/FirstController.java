package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "saki");
        return "greetings"; // template 명 / greetings.mustache
    }

    @GetMapping("/bye")
    public String seeYouAgain(Model model) {
        model.addAttribute("nickname", "사키");
        return "goodbye";
    }
}
