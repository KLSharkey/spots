package com.liftoff.spots.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="login")
public class LoginController {

    @RequestMapping(value="signup", method = RequestMethod.GET)
    public String displaySignUpPage(Model model) {

        model.addAttribute("title", "Spots");

        return "login/userSignUp";
    }

    @RequestMapping(value="existing", method = RequestMethod.GET)
    public String displayLoginPage(Model model) {

        model.addAttribute("title", "Spots");

        return "login/userLogIn";
    }
}
