package com.example.redditproject.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/liked_posts")
public class LikedPostController {

    @GetMapping("/")
    @ResponseBody
    public String page(){
        return "Working on it..";
    }
}
