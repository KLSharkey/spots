package com.liftoff.spots.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "")
public class testGetLoc {


        //@Autowired
        //private com.liftoff.spots.models.data.userDao userDao;

        @RequestMapping(value = "getLocation", method = RequestMethod.GET)
        public String displayLocation(Model model) {

            //model.addAttribute("title", "Spots");
            //model.addAttribute( "user", new User() );

            return "geolocation/getLocation";
        }

    }
