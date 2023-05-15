package com.geekster.Instagram_basic_model.controller;

import com.geekster.Instagram_basic_model.models.Post;
import com.geekster.Instagram_basic_model.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/savePost")
    public void savePost(@RequestBody Post post){
        postService.save(post);
    }

    @GetMapping("/getPost/{id}")
    public Post getPostById(@PathVariable Long id){
       return postService.getPostById(id);
    }

}
