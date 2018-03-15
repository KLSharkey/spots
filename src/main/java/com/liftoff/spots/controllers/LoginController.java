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
        model.addAttribute(new User());

        return "login/userLogIn";
    }

    @RequestMapping(value="existing", method = RequestMethod.POST)
    //public String formProcessLoginPage(Model model, @ModelAttribute("user") User user,HttpServletRequest request,
                                      // HttpServletResponse response) {

    public String formProcessLoginPage(@ModelAttribute @Valid User myUser, Errors errors,
                Model model, HttpServletRequest request, String password,
                HttpServletResponse response){
        model.addAttribute("title", "Login");
            Iterable<User> users = userDao.findAll();

            for (User user : users) {
                if (user.getEmail().equals(myUser.getEmail())) {
                    if (user.getPassword().equals(myUser.getPassword())) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userLoggedIn", user);
                        System.out.println(user.getEmail());

                        return "redirect: ../../../MySpots";

                    } else {
                        //return login page with password error
                        model.addAttribute("title", "Login");
                        model.addAttribute("passwordError", "Incorrect password.");
                        return "";
                    }
                }
            }
            //return login page with username error
            model.addAttribute("title", "Login");
            model.addAttribute("usernameError", "An account doesn't exist under that email.");
            return "";
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
        HttpSession session = request.getSession();
        session.setAttribute("userLoggedIn", newUser);

        return "redirect: ../../../MySpots";

    }

    @RequestMapping(value = "logout",  method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("userLoggedIn");
        if (session.getAttribute("userLoggedIn") == null){
            System.out.println(session.getAttribute("userLoggedIn"));
        }



        return "redirect:/Home";
    }

}
