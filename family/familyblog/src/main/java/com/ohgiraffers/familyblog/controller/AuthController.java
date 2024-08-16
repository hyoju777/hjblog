package com.ohgiraffers.familyblog.controller;

import com.ohgiraffers.familyblog.dto.UserRegistrationDTO;
import com.ohgiraffers.familyblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "auth/login";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new UserReigstrationDTO());
        return "auth/signup";
    }

    @PostMapping("/singup")
    public String registerUser(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO) {
        userService.save(userRegistrationDTO);
        return "redirect:/login";
    }
}



// AuthController인증과 관련된 요청을 처리한다. 로그인 로그아웃 회원 가입 등을 담당한다.