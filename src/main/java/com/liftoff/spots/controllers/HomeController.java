package com.liftoff.spots.controllers;

import com.liftoff.spots.models.User;
import com.liftoff.spots.models.data.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value="Home")
public class HomeController {

        @RequestMapping(value="", method = RequestMethod.GET)
        public String displaySignUpPage(Model model) {

            model.addAttribute("title", "Spots");

            return "Home";
        }

}
