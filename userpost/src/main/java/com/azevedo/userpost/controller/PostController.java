package com.azevedo.userpost.controller;

import com.azevedo.userpost.domain.Post;
import com.azevedo.userpost.dto.PostResponse;
import com.azevedo.userpost.mapper.PostMapper;
import com.azevedo.userpost.sevice.PostService;
import com.azevedo.userpost.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/title-search")
    public ResponseEntity<List<PostResponse>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String text) {

        text = URL.decodeParam(text);

        List<PostResponse> response = postService.findByTitle(text)
                .stream()
                .map(PostMapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }


}
