package com.example.redditproject.webcontrollers;

import com.example.redditproject.models.RedditUser;
import com.example.redditproject.services.RedditUserService;
import com.example.redditproject.services.TrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/your_posts")
public class YourPostsController {

    private final RedditUserService redditUserService;
    private final TrendService trendService;
    @Autowired
    public YourPostsController(RedditUserService redditUserService, TrendService trendService) {
        this.redditUserService = redditUserService;
        this.trendService = trendService;
    }

    @GetMapping("/page/{userId}")
    public String page(@PathVariable Long userId, Model model){
        model.addAttribute("userId",userId);
        model.addAttribute("posts",redditUserService.getById(userId).get().getUserPosts());
        return "your_posts";
    }

    @PostMapping("/delete/{postId}")
    public String deletePost(@PathVariable Long postId, RedirectAttributes redirectAttributes) {
        Optional<RedditUser> userOptional = redditUserService.findUserByPostId(postId);

        userOptional.ifPresent(user -> {
            user.getUserPosts().removeIf(post -> post.getPostId().equals(postId));
            redditUserService.saveUser(user);
        });

        trendService.deleteById(postId);
        redirectAttributes.addAttribute("userId", userOptional.map(RedditUser::getUserId).orElse(null));
        return "redirect:/your_posts/page/{userId}";
    }


}
