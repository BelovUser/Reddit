package com.example.redditproject.webcontrollers;

import com.example.redditproject.services.RedditUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class RedditUserController {

    private final RedditUserService redditUserService;

    @Autowired
    public RedditUserController(RedditUserService redditUserService) {
        this.redditUserService = redditUserService;
    }
}
