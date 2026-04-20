package com.azevedo.userpost.mapper;

import com.azevedo.userpost.domain.Post;
import com.azevedo.userpost.dto.PostResponse;

public class PostMapper {

    public static PostResponse toDTO(Post post) {
        return new PostResponse(
                post.getId(),
                post.getCreatedAt(),
                post.getTitle(),
                post.getBody(),
                post.getAuthor(),
                post.getComments()
        );
    }
}
