package com.geekster.Instagram_basic_model.services;

import com.geekster.Instagram_basic_model.models.AuthenticationToken;
import com.geekster.Instagram_basic_model.models.Users;
import com.geekster.Instagram_basic_model.repositories.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    ITokenRepo tokenRepo;
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public AuthenticationToken getToken(Users user) {
        return tokenRepo.findByUser(user);
    }
}
