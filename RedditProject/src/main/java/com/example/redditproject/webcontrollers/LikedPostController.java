package com.example.redditproject.webcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/liked_posts")
public class LikedPostController {

    @GetMapping("/")
    public String page(){
        return "liked_posts";
    }
}
