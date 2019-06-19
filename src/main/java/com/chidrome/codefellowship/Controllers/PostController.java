package com.chidrome.codefellowship.Controllers;

import com.chidrome.codefellowship.Models.AppUser;
import com.chidrome.codefellowship.Models.Post;
import com.chidrome.codefellowship.Repository.AppUserRepository;
import com.chidrome.codefellowship.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.sql.Timestamp;

@Controller
public class PostController {

    @Autowired
    PostRepository postRepository;
    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/addPost")
    public String getPostPage() {
        return "post";
    }

    @PostMapping("/addPost")
    public RedirectView createNewPost(String body, Principal p){
        AppUser user = appUserRepository.findByUsername(p.getName());
        Post newPost = new Post();
        newPost.body = body;
        newPost.createdAt = new Timestamp(System.currentTimeMillis());
        newPost.creator = user;
//        Post newPost = new Post(body, createdAt, user);
        postRepository.save(newPost);
        return new RedirectView("/profile");

    }

}
