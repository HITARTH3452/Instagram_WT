package com.geekster.Instagram_basic_model.repositories;

import com.geekster.Instagram_basic_model.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Long> {
}
