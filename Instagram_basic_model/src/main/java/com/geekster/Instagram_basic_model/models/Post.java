package com.geekster.Instagram_basic_model.models;

import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@NoArgsConstructor
public class Post {

    private Integer postId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String postData;

    @ManyToOne(fetch = FetchType.LAZY)
    private Users users;
}
