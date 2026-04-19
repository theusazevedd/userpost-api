package com.azevedo.userpost.mapper;

import com.azevedo.userpost.domain.User;
import com.azevedo.userpost.dto.UserRequest;
import com.azevedo.userpost.dto.UserResponse;

public class UserMapper {

    public static UserResponse toDTO(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public static User toEntity(UserRequest dto) {
        return new User(
                null,
                dto.getName(),
                dto.getEmail()
        );
    }

}
