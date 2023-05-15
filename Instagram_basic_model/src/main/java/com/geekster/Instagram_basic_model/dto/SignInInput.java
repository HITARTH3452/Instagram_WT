package com.geekster.Instagram_basic_model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {

    private String userEmail;
    private String userPassword;
}
