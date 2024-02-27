package com.example.rcpproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    String login(){
        return "login-form";
    }


@PostMapping("/login")
String checkLogin(){
    return "menu";
}
}
