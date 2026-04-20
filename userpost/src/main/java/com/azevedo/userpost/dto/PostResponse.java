package com.azevedo.userpost.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PostResponse {

    private String id;
    private LocalDate createAt;
    private String title;
    private String body;
    private AuthorDTO author;


}
