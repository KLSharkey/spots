package com.liftoff.spots.controllers;

import com.liftoff.spots.models.User;
import com.liftoff.spots.models.data.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value="login")
public class LoginController {

    @Autowired
    private userDao userDao;

    @RequestMapping(value="signup", method = RequestMethod.GET)
    public String displaySignUpPage(Model model) {

        model.addAttribute("title", "Spots");
        model.addAttribute( "user", new User() );

        return "login/userSignUp";
    }

    @RequestMapping(value="existing", method = RequestMethod.GET)
    public String displayLoginPage(Model model) {

        model.addAttribute("title", "Spots");

        return "login/userLogIn";
    }

    @RequestMapping(value="signup", method = RequestMethod.POST)
    public String processSignUpForm(@ModelAttribute @Valid User newUser,
                                     Errors errors, Model model) {
        if ( errors.hasErrors() ) {
            model.addAttribute( "errors", errors);
            model.addAttribute("title", "Spots");

            return "login/userSignUp";
        }

        userDao.save(newUser);

        return "redirect:signup";

    }

}
