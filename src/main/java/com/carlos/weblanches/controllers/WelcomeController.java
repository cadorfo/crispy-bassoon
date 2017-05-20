package com.carlos.weblanches.controllers;

import com.carlos.weblanches.services.MenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {

    @Autowired
    private MenuServices menu;

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {

        model.put("sandwiches", menu.listSandwitches());

        return "welcome";
    }
}
