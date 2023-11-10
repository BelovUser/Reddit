package com.example.redditproject.webcontrollers;

import com.example.redditproject.services.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/trend")
public class PageController {

    private final TrendService trendService;

    @Autowired
    public PageController(TrendService trendService) {
        this.trendService = trendService;
    }

    @GetMapping("/posts")
    public String homePage(Model model){
        model.addAttribute("posts",trendService.getTrendingPosts());
        return "index";
    }

    @GetMapping("/add")
    public String addPage(){
        return "add";
    }

    @PostMapping("/update")
    public String update(){
        return "redirect: /trend/posts";
    }
}
