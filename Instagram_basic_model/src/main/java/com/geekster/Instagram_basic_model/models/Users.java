package com.geekster.Instagram_basic_model.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userFirstName;
    private String userLastName;
    private Integer userAge;
    private String userEmail;
    private String userPassword;
    private String userContact;

    public Users(String userFirstName, String userLastName, Integer userAge, String userEmail, String userPassword, String userContact) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userContact = userContact;
    }

}
