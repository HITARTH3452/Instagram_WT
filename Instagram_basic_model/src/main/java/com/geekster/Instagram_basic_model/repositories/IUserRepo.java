package com.geekster.Instagram_basic_model.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String userEmail);
}
