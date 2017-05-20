package com.carlos.weblanches.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", "olá");
        return "welcome";
    }
}
