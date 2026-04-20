package com.azevedo.userpost.controller;

import com.azevedo.userpost.domain.Post;
import com.azevedo.userpost.dto.PostResponse;
import com.azevedo.userpost.mapper.PostMapper;
import com.azevedo.userpost.sevice.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        PostResponse response = PostMapper.toDTO(post);
        return ResponseEntity.ok().body(response);

    }


}
