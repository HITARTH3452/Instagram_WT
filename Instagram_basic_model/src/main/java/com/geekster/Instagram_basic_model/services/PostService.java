package com.geekster.Instagram_basic_model.services;

import com.geekster.Instagram_basic_model.models.Post;
import com.geekster.Instagram_basic_model.repositories.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    IPostRepo postRepo;
    public void save(Post post) {
        postRepo.save(post);
    }

    public Post getPostById(Long id) {
        return postRepo.getById(id);
    }
}
