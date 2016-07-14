package edu.nju.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "questionPage";
    }
    
}
