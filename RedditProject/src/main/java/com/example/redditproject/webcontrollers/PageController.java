package com.example.redditproject.webcontrollers;

import com.example.redditproject.models.TrendPost;
import com.example.redditproject.services.TrendService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.VariableElement;
import java.util.Optional;

@Controller
@RequestMapping("/trend")
public class PageController {

    private final TrendService trendService;

    @Autowired
    public PageController(TrendService trendService) {
        this.trendService = trendService;
    }

    @GetMapping("/posts/{userId}")
    public String homePage(Model model, @PathVariable Optional<Long> userId) {
        if(userId.isEmpty()){
            return "redirect:/register/page";
        }
        model.addAttribute("posts", trendService.getPostsSortedByLikes());
        return "index";
    }

    @GetMapping("/add")
    public String addPost() {
        return "add";
    }


    @PostMapping("/update")
    public String update(@RequestParam String title, @RequestParam String url) {
        TrendPost tp = new TrendPost();
        tp.setTitle(title);
        tp.setUrl(url);
        trendService.saveTrendPost(tp);
        return "redirect:/trend/posts";
    }

    @PostMapping("/like/{id}")
    public String incrementLike(@PathVariable long id) {
        TrendPost post = trendService.getTrendPostById(id).get();
        post.setLikes(post.getLikes() + 1);
        trendService.saveTrendPost(post);
        return "redirect:/trend/posts";
    }

    @PostMapping("/dislike/{id}")
    public String decrementLike(@PathVariable long id) {
        TrendPost post = trendService.getTrendPostById(id).get();
        post.setLikes(post.getLikes() - 1);
        trendService.saveTrendPost(post);
        return "redirect:/trend/posts";
    }
}
