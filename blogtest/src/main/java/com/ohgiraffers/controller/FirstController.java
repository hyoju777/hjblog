package com.ohgiraffers.controller;

import org.springframework.stereotype.Controller;

@Controller
public class FirstController {

@Getmapping("/hi")
    public String niceToMeetYou(Model model) {
    model.addAttribute("username","홍팍");
        return "greetings";
    }
}
