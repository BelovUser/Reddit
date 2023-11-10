package com.example.redditproject.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acc")
public class AccController {

    @GetMapping("/information")
    public String informationPage(){
        return "acc_information";
    }
}
