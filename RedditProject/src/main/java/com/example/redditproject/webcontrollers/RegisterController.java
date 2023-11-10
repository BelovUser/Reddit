package com.example.redditproject.webcontrollers;

import com.example.redditproject.models.RedditUser;
import com.example.redditproject.services.RedditUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final RedditUserService redditUserService;

    @Autowired
    public RegisterController(RedditUserService redditUserService) {
        this.redditUserService = redditUserService;
    }

    @GetMapping("/page")
    public String registerPage(){
        return "register";
    }

    @PostMapping("/create")
    public String createAcc(@RequestParam String username, @RequestParam String password){
        RedditUser rd = new RedditUser();
        rd.setPassword(password);
        rd.setUsername(username);
        redditUserService.saveUser(rd);
        return "redirect:/trend/posts";
    }
}
