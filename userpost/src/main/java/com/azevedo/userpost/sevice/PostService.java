package com.azevedo.userpost.sevice;

import com.azevedo.userpost.domain.Post;
import com.azevedo.userpost.exceptions.ResourceNotFoundException;
import com.azevedo.userpost.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public Post findById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID não encontrado"));

    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }


}