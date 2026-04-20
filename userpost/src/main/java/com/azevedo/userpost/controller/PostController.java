package com.azevedo.userpost.controller;

import com.azevedo.userpost.domain.Post;
import com.azevedo.userpost.dto.PostResponse;
import com.azevedo.userpost.mapper.PostMapper;
import com.azevedo.userpost.sevice.PostService;
import com.azevedo.userpost.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/titlesearch")
    public ResponseEntity<List<PostResponse>> findByTitle(
            @RequestParam(value = "text", defaultValue = "") String text) {

        text = URL.decodeParam(text);

        List<PostResponse> response = postService.findByTitle(text)
                .stream()
                .map(PostMapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<PostResponse>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate) {

        text = URL.decodeParam(text);

        LocalDate min = URL.convertDate(minDate, LocalDate.of(1970, 1, 1));
        LocalDate max = URL.convertDate(maxDate, LocalDate.now());

        List<PostResponse> response = postService.fullSearch(text, min, max)
                .stream()
                .map(PostMapper::toDTO)
                .toList();

        return ResponseEntity.ok(response);
    }


}
