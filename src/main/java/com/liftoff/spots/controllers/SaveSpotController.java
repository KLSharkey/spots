package com.liftoff.spots.controllers;


import com.liftoff.spots.models.Spot;
import com.liftoff.spots.models.User;
import com.liftoff.spots.models.data.spotDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.HashSet;


@Controller
//@RequestMapping(value = "")
@RequestMapping(value = "geolocation")
public class SaveSpotController {

    @Autowired
    private spotDAO spotDAO;

    //@Autowired
    //private com.liftoff.spots.models.data.userDao userDao;

    //@RequestMapping(value = "getLocation", method = RequestMethod.GET)
    @RequestMapping(value = "getLocation", method = RequestMethod.GET)
    public String displayLocation(Model model) {

        //model.addAttribute("title", "Spots");
        //model.addAttribute( "user", new User() );

        return "geolocation/getLocation";
    }

    //@RequestMapping(value = "test")
    @RequestMapping(value = "getLocation/current", method = RequestMethod.POST)
    //public @ResponseBody String processFormCurrentSpot(@RequestBody Spot jsonObject) {
    public @ResponseBody
    String processFormCurrentSpot(@RequestBody Spot jsonObject) {
        double latitude = jsonObject.getLatitude();
        double longitude = jsonObject.getLongitude();
            /*String spotName = jsonObject.getSpotName();
            String spotInfo = jsonObject.getSpotInfo();
            System.out.println(longitude);
            System.out.println(latitude);
            System.out.println(spotName);
            System.out.println(spotInfo);*/

        spotDAO.save(jsonObject);
        System.out.println("here");
        return "";

    }

    @RequestMapping(value = "notCurrent", method = RequestMethod.GET)
    public String displayLocationNotCurrent(Model model) {

        return "geolocation/setLocationNotCurrent";
    }



    @RequestMapping(value = "notCurrent", method = RequestMethod.POST)
    public @ResponseBody
    String processFormNotCurrent(@RequestBody Spot jsonObject, HttpServletRequest request, HttpServletResponse response) {
        double latitude = jsonObject.getLatitude();
        double longitude = jsonObject.getLongitude();
        HttpSession session = request.getSession();
        User myUser = (User) session.getAttribute("userLoggedIn");
        System.out.println(myUser.getEmail());
        jsonObject.setUser(myUser);

        spotDAO.save(jsonObject);

        return "";

    }
}



