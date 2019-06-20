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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;

@Controller
public class FriendsController {


    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    PostRepository postRepository;


    @GetMapping("/friends")
    public String findAFriend(Model m, Principal p){
        AppUser currentUser = (AppUser)((UsernamePasswordAuthenticationToken) p).getPrincipal();
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("principal", currentUser);
        m.addAttribute("user", true);
        return "searchFriend";

    }

    @GetMapping("/friendsProfile")
    public String getFriendsProfile(Model m, Principal p){
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("user", true);
        return "friendsProfile";
    }

    @PostMapping("/searchFriend")
    public RedirectView foundFriends(Model m, Principal p, @RequestParam String username){
        AppUser friend =  appUserRepository.findByUsername(username);
        AppUser user = appUserRepository.findByUsername(p.getName());
        m.addAttribute("friend", friend);
//        m.addAttribute("user", true);
        System.out.println(friend);

        return new RedirectView("/friendsProfile");
    }

}
