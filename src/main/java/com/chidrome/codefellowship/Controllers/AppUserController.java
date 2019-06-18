package com.chidrome.codefellowship.Controllers;

import com.chidrome.codefellowship.Repository.AppUserRepository;
import com.chidrome.codefellowship.Models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class AppUserController {

    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public RedirectView createNewUser(String username, String password, String firstName, String lastName, Date dob, String bio){
        AppUser newCreatedUser = new AppUser(username, bCryptPasswordEncoder.encode(password), firstName, lastName, dob, bio);
        appUserRepository.save(newCreatedUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(newCreatedUser, null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/profile");

    }

}
