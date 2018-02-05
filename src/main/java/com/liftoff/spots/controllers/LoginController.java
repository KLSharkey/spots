package com.liftoff.spots.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    @RequestMapping(value="login")
    public String index(Model model) {

        model.addAttribute("title", "Spots");

        return "login/userSignUp";
    }
}
