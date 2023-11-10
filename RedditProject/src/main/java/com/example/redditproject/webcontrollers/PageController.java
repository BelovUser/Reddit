package com.example.redditproject.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trend")
public class PageController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }
}
