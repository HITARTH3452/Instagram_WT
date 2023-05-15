package com.geekster.Instagram_basic_model.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreationDate;


    @OneToOne
    private Users user;

    public AuthenticationToken(String token, LocalDate tokenCreationDate, Users user) {
        this.token = token;
        this.tokenCreationDate = tokenCreationDate;
        this.user = user;
    }
}
