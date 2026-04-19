package com.azevedo.userpost.controller;

import com.azevedo.userpost.domain.User;
import com.azevedo.userpost.dto.UserRequest;
import com.azevedo.userpost.dto.UserResponse;
import com.azevedo.userpost.mapper.UserMapper;
import com.azevedo.userpost.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable String id) {
        User user = userService.findById(id);
        UserResponse response = UserMapper.toDTO(user);
        return ResponseEntity.ok().body(response);

    }

    @PostMapping
    public ResponseEntity<UserResponse> insert(@RequestBody UserRequest request) {
        UserResponse response = userService.insert(request);
        return ResponseEntity.ok().body(response);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable String id,
                                               @RequestBody UserRequest request) {
        UserResponse userResponse = userService.update(id, request);
        return ResponseEntity.ok().body(userResponse);
    }


}
