package com.azevedo.userpost.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostResponse {

    private String id;
    private LocalDate createdAt;
    private String title;
    private String body;
    private AuthorDTO author;
    private List<CommentDTO> comments;



}
