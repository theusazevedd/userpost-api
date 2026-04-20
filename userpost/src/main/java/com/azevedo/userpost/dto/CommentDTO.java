package com.azevedo.userpost.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private String text;
    private LocalDate createAt;
    private AuthorDTO author;

}
