package com.example.redditproject.webcontrollers;

import com.example.redditproject.services.RedditUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_posts")
public class YourPostsController {

    private final RedditUserService redditUserService;
    @Autowired
    public YourPostsController(RedditUserService redditUserService) {
        this.redditUserService = redditUserService;
    }

    @GetMapping("/page/{userId}")
    public String page(@PathVariable Long userId, Model model){
        model.addAttribute("userId",userId);
        model.addAttribute("posts",redditUserService.getById(userId).get().getUserPosts());
        return "your_posts";
    }
}
