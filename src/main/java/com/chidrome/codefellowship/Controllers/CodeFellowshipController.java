package com.chidrome.codefellowship.Controllers;

import com.chidrome.codefellowship.Models.AppUser;
import com.chidrome.codefellowship.Models.Post;
import com.chidrome.codefellowship.Repository.AppUserRepository;
import com.chidrome.codefellowship.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class CodeFellowshipController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/profile")
    public String getProfilePage(Principal p, Model m){
        AppUser currentUser = (AppUser)((UsernamePasswordAuthenticationToken) p).getPrincipal();
        AppUser posts = appUserRepository.findByUsername(p.getName());
        m.addAttribute("principal", currentUser);
        m.addAttribute("posts", posts);
        return "profile";
    }


}
