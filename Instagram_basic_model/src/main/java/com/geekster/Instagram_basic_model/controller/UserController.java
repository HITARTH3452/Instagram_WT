package com.geekster.Instagram_basic_model.controller;

import com.geekster.Instagram_basic_model.dto.SignInInput;
import com.geekster.Instagram_basic_model.dto.SignInOutput;
import com.geekster.Instagram_basic_model.dto.SignUpInput;
import com.geekster.Instagram_basic_model.dto.SignUpOutput;
import com.geekster.Instagram_basic_model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public SignUpOutput signup(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    //Sign in
    @PostMapping("/signin")
    public SignInOutput signin(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @PutMapping("/updateById/{id}/{name}")
    public void updateUser(@PathVariable Long userId, @PathVariable String name){
        userService.updateNameById(userId,name);
    }
}
