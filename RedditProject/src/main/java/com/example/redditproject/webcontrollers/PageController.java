package com.example.redditproject.webcontrollers;

import com.example.redditproject.models.RedditUser;
import com.example.redditproject.models.TrendPost;
import com.example.redditproject.services.RedditUserService;
import com.example.redditproject.services.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/trend")
public class PageController {

    private final RedditUserService redditUserService;
    private final TrendService trendService;

    @Autowired
    public PageController(RedditUserService redditUserService, TrendService trendService) {
        this.redditUserService = redditUserService;
        this.trendService = trendService;
    }

    @GetMapping("/posts/{userId}")
    public String homePage(Model model, @PathVariable Optional<Long> userId) {
        if (userId.isEmpty()) {
            return "redirect:/register/page";
        }
        model.addAttribute("posts", trendService.getPostsSortedByLikes(0, 10));
        model.addAttribute("user", redditUserService.getById(userId.get()).get());
        return "index";
    }

    @PostMapping("/ten_more/{userId}")
    public String morePostsOnPage(Model model, @PathVariable Optional<Long> userId, @RequestParam Optional<Integer> fromPage, @RequestParam Optional<Integer> toPage, RedirectAttributes redirectAttributes) {
        if (userId.isEmpty()) {
            return "redirect:/register/page";
        }
        if (fromPage.isPresent() && toPage.isPresent()) {
            trendService.addPages(fromPage.get(), toPage.get());
            model.addAttribute("posts", trendService.addPages(fromPage.get(), toPage.get()));
        } else {
            model.addAttribute("posts", trendService.getPostsSortedByLikes(0, 10));
        }
        model.addAttribute("user", redditUserService.getById(userId.get()).orElse(null));

        redirectAttributes.addAttribute("userId", userId.get());
        return "redirect:/trend/posts/{userId}";

    }


    @GetMapping("/add/{userId}")
    public String addPost(@PathVariable Long userId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("userId", userId);
        return "add";
    }


    @PostMapping("/update/{userId}")
    public String update(@RequestParam String title, @RequestParam String url, @PathVariable Long userId, RedirectAttributes redirectAttributes) {
        TrendPost tp = new TrendPost();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        tp.setTitle(title);
        tp.setUrl(url);
        tp.setDate(formatter.format(new Date()));
        trendService.saveTrendPost(tp);

        RedditUser userOptional = redditUserService.getById(userId).get();
        userOptional.getUserPosts().add(tp);
        redditUserService.saveUser(userOptional);

        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/trend/posts/{userId}";
    }


    @PostMapping("/like/{id}/{userId}")
    public String incrementLike(@PathVariable long userId,@PathVariable long id,RedirectAttributes redirectAttributes) {
        TrendPost post = trendService.getTrendPostById(id).get();
        post.setLikes(post.getLikes() + 1);
        trendService.saveTrendPost(post);
        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/trend/posts/{userId}";
    }

    @PostMapping("/dislike/{id}/{userId}")
    public String decrementLike(@PathVariable long userId,@PathVariable long id,RedirectAttributes redirectAttributes) {
        TrendPost post = trendService.getTrendPostById(id).get();
        post.setLikes(post.getLikes() - 1);
        trendService.saveTrendPost(post);
        redirectAttributes.addAttribute("userId",userId);
        return "redirect:/trend/posts/{userId}";
    }
}
