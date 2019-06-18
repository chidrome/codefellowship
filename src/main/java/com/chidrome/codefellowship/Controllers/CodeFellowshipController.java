package com.chidrome.codefellowship.Controllers;

import com.chidrome.codefellowship.Models.AppUser;
import com.chidrome.codefellowship.Repository.AppUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class CodeFellowshipController {


    @GetMapping("/")
    public String getHomePage(){
        return "home";
    }

    @GetMapping("/profile")
    public String getProfilePage(Principal p, Model m){
        AppUser currentUser = (AppUser)((UsernamePasswordAuthenticationToken) p).getPrincipal();
        m.addAttribute("principal", currentUser);
        return "profile";
    }

}
