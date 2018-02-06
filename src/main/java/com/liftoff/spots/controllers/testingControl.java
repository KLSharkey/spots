package com.liftoff.spots.controllers;

import com.liftoff.spots.models.data.userDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

public class testingControl {

    @Autowired //framework makes instance of class
    private userDao theuserDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
    return "";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String delete(Model model) {
    return "";
}





}
