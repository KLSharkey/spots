package com.liftoff.spots.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liftoff.spots.models.Spot;
import com.liftoff.spots.models.User;
import com.liftoff.spots.models.data.spotDAO;
import com.liftoff.spots.models.data.userDao;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


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

        /*ObjectMapper mapper = new ObjectMapper();

        ArrayNode arrayNode = mapper.createArrayNode();


         * Create three JSON Objects objectNode1, objectNode2, objectNode3
         * Add all these three objects in the array
         *

        com.fasterxml.jackson.databind.node.ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("bookName", "Java");
        objectNode1.put("price", "100");

        com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = mapper.createObjectNode();
        objectNode2.put("bookName", "Spring");
        objectNode2.put("price", "200");

        com.fasterxml.jackson.databind.node.ObjectNode objectNode3 = mapper.createObjectNode();
        objectNode3.put("bookName", "Liferay");
        objectNode3.put("price", "500");

        /**
         * Array contains JSON Objects

        arrayNode.add(objectNode1);
        arrayNode.add(objectNode2);
        arrayNode.add(objectNode3);*/
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
    @RequestMapping(value = "MySpots/ASpot")
    public String bookMarkTutorial (
            @RequestParam(required = true) int spotID,
            Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("right here");
        model.addAttribute("A spot : " + spotID);

        Spot mySpot = spotDAO.findOne(spotID);
        double latitude = mySpot.getLatitude();
        double longitude = mySpot.getLongitude();
        model.addAttribute("Latitude", latitude);
        model.addAttribute("Longitude", longitude);
        model.addAttribute("Longitude" + longitude);
        System.out.println(latitude);
        HttpSession session = request.getSession();
        User myUser = (User) session.getAttribute("userLoggedIn");


        //session.setAttribute("mySpot", mySpot);
         /*ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
         // Create three JSON Objects objectNode1, objectNode2, objectNode3
         // Add all these three objects in the array

        com.fasterxml.jackson.databind.node.ObjectNode objectNode1 = mapper.createObjectNode();
        objectNode1.put("lat", mySpot.getLatitude());
        com.fasterxml.jackson.databind.node.ObjectNode objectNode2 = mapper.createObjectNode();
        objectNode2.put("long", mySpot.getLongitude());
        arrayNode.add(objectNode1);
        arrayNode.add(objectNode2);*/

        /*String json = new Gson().toJson(mySpot);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
        String latLong = "{\"lat\":" + mySpot.getLatitude() + ",\"Longitude\":" + mySpot.getLongitude()+ "}";
        request.getSession().setAttribute("latLong", latLong);*/
       // HttpSession myLocation = request.getSession(true);
       // myLocation.setAttribute("mySpot", mySpot);
        //request.getRequestDispatcher("ASpot");
        //System.out.println(mySpot.getLatitude());

       /* Map<String, Double> options = new LinkedHashMap<>();
        options.put("lat", mySpot.getLatitude());
        options.put("long", mySpot.getLongitude());

        String json = new Gson().toJson(options);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
System.out.println(json);*/
        /*List<Double> list = new ArrayList<>();
        list.add(mySpot.getLatitude());
        list.add(mySpot.getLongitude());

        String json = new Gson().toJson(list);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);*/

        return "ASpot";

    }



}
