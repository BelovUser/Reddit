package com.example.redditproject.webcontrollers;

import com.example.redditproject.models.RedditUser;
import com.example.redditproject.services.RedditUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/acc")
public class AccController {

    private final RedditUserService redditUserService;

    @Autowired
    public AccController(RedditUserService redditUserService) {
        this.redditUserService = redditUserService;
    }


    @GetMapping("/information/{userId}")
    public String informationPage(@PathVariable Long userId, Model model){
        model.addAttribute("user", redditUserService.getById(userId).get());
        return "acc_information";
    }

    @PostMapping("update/{userId}")
    public String update(@PathVariable Long userId, @RequestParam String username, @RequestParam String password, RedirectAttributes redirectAttributes){
        RedditUser us = redditUserService.getById(userId).get();
        us.setUsername(username);
        us.setPassword(password);
        redditUserService.saveUser(us);
        redirectAttributes.addAttribute("userId",userId);
        return "redirect:/acc/information/{userId}";
    }
}
