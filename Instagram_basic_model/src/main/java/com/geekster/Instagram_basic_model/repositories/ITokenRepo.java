package com.geekster.Instagram_basic_model.repositories;


import com.geekster.Instagram_basic_model.models.AuthenticationToken;
import com.geekster.Instagram_basic_model.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITokenRepo extends JpaRepository<AuthenticationToken,Long> {

    AuthenticationToken findByUser(Users user);
}
