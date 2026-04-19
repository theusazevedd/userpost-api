package com.azevedo.userpost.controller;

import com.azevedo.userpost.domain.User;
import com.azevedo.userpost.dto.UserResponse;
import com.azevedo.userpost.mapper.UserMapper;
import com.azevedo.userpost.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> list = userService.findAll();

        List<UserResponse> response = list.stream()
                .map(UserMapper::toDTO)
                .toList();

        return ResponseEntity.ok().body(response);
    }


}
