package com.liftoff.spots.controllers;

import com.liftoff.spots.models.LatLng;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.HashSet;


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

    @RequestMapping(value = "test")
    public @ResponseBody String processForm(@RequestBody LatLng jsonObject) {
            double latitude = jsonObject.getLatitude();
            double longitude = jsonObject.getLongitude();
            System.out.println(longitude);
            System.out.print(latitude);
            //System.out.println(jsonObject.toString());
            //System.out.println(request.getParameter("latitude"));

            //System.out.println(jsonObject.toString());
            //System.out.println(jsonObject.getClass().getName());
            /*System.out.println(jsonObject.getLatitude());
            LatLng newLatLng = new LatLng(jsonObject.getLatitude(), jsonObject.getLongitude());
            double lat = newLatLng.getLatitude();
            double lng = newLatLng.getLongitude();
            System.out.println(lat);*/

            return "test";

    }

    }
