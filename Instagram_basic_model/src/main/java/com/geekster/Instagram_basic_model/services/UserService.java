package com.geekster.Instagram_basic_model.services;

import com.geekster.Instagram_basic_model.dto.SignInInput;
import com.geekster.Instagram_basic_model.dto.SignInOutput;
import com.geekster.Instagram_basic_model.dto.SignUpInput;
import com.geekster.Instagram_basic_model.dto.SignUpOutput;
import com.geekster.Instagram_basic_model.models.AuthenticationToken;
import com.geekster.Instagram_basic_model.models.Users;
import com.geekster.Instagram_basic_model.repositories.IUserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService tokenService;

    public SignUpOutput signUp(SignUpInput signUpDto) {

        User user = userRepo.findFirstByUserEmail(signUpDto.getUserEmail());

        if(user != null){
            throw new IllegalStateException("user already exists!!!..");
        }


        String encryptedPassword = null;
        try {
            encryptedPassword = encryptPassword(signUpDto.getUserPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        user = new Users(signUpDto.getUserFirstName(),signUpDto.getUserLastName(),signUpDto.getUserPassword(),signUpDto.getUserEmail(),signUpDto.getUserContact(),signUpDto.getUserAge());

        userRepo.save(user);

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        return new SignUpOutput("user registerd" , "user created");
    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        return new BigInteger(1,md5.digest()).toString(16);
    }

    public SignInOutput signIn(SignInInput signInDto) {
        Users user = (Users) userRepo.findFirstByUserEmail(signInDto.getUserEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //encrypt the password

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getUserPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        //figure out the token

        AuthenticationToken authToken = tokenService.getToken(user);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!",authToken.getToken());

    }

    public void updateNameById(Long userId, String name) {
        User user = userRepo.getById(userId);

        if(user != null){
            user.setUsername(name);
        }
    }
}
