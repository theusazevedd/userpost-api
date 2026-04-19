package com.azevedo.userpost.sevice;

import com.azevedo.userpost.domain.User;
import com.azevedo.userpost.dto.UserRequest;
import com.azevedo.userpost.dto.UserResponse;
import com.azevedo.userpost.exceptions.ResourceNotFoundException;
import com.azevedo.userpost.mapper.UserMapper;
import com.azevedo.userpost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));

    }

    public UserResponse insert(UserRequest request) {
        User user = UserMapper.toEntity(request);
        User saved = userRepository.save(user);
        return UserMapper.toDTO(saved);

    }
}