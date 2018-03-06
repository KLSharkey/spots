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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes("user")
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
                                     Errors errors, HttpServletRequest request, HttpServletResponse response,
                                    Model model) {
        if ( errors.hasErrors() ) {
            model.addAttribute( "errors", errors);
            model.addAttribute("title", "Spots");

            return "login/userSignUp";
        }

        userDao.save(newUser);
        //int userID = newUser.getId();
        HttpSession session = request.getSession();
        session.setAttribute("userLoggedIn", newUser);
        //response.encodeRedirectURL("geolocation/notCurrent");
        //Object username = session.getAttribute("userLoggedIn");
        //System.out.println(username);

        return "redirect:../geolocation/notCurrent";

    }

}
