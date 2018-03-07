package com.liftoff.spots.controllers;


import com.liftoff.spots.models.Spot;
import com.liftoff.spots.models.User;
import com.liftoff.spots.models.data.spotDAO;
import com.liftoff.spots.models.data.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="")
public class UserController {


    @Autowired
    private com.liftoff.spots.models.data.userDao userDao;

    @Autowired
    private com.liftoff.spots.models.data.spotDAO spotDAO;

    @RequestMapping(value = "MySpots", method = RequestMethod.GET)
    public String displaySignUpPage(Model model, HttpServletRequest request, HttpServletResponse response) {

        model.addAttribute("title", "Spots");
        model.addAttribute("user", new User());
        HttpSession session = request.getSession();
        User myUser = (User) session.getAttribute("userLoggedIn");
        System.out.println(myUser.getEmail());
        Iterable<Spot> allSpots= spotDAO.findAll();
        ArrayList<Spot> mySpots = new ArrayList<Spot>();
        for (Spot spot : spotDAO.findAll()) {
           // System.out.println(spot.getUser());
            if ((spot.getUser()).getId() == myUser.getId()) {
                System.out.println(spot.getUserID());
                mySpots.add(spot);

            }
        }
        System.out.println(mySpots);
        model.addAttribute("mySpots", mySpots);

        return "MySpots";
    }

}
