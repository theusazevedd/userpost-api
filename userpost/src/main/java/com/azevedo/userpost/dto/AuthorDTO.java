package com.azevedo.userpost.dto;

import com.azevedo.userpost.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDTO {

    private String id;
    private String name;

    public AuthorDTO() {

    }

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

}
