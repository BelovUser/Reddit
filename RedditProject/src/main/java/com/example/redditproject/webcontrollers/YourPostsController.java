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
        model.addAttribute("user", redditUserService.getById(userId).get());
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
        redirectAttributes.addAttribute("userId", userOptional.get().getUserId());
        return "redirect:/your_posts/page/{userId}";
    }

    @GetMapping("/edit/{postId}/{userId}")
    public String editPage(@PathVariable Long postId,@PathVariable Long userId, Model model) {
        model.addAttribute("postId",postId);
        model.addAttribute("userId",userId);
        model.addAttribute("post", trendService.getTrendPostById(postId));
        return "edit_post";
    }

    @PostMapping("/update/{postId}/{userId}")
    public String changePost(@PathVariable Long postId,@RequestParam String title,@RequestParam String url, RedirectAttributes redirectAttributes,@PathVariable Long userId) {
        TrendPost post = trendService.getTrendPostById(postId).get();
        post.setTitle(title);
        post.setUrl(url);
        trendService.saveTrendPost(post);
        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/your_posts/page/{userId}";
    }

}
