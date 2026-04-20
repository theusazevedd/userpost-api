package com.azevedo.userpost.domain;

import com.azevedo.userpost.dto.AuthorDTO;
import com.azevedo.userpost.dto.CommentDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@Document(collection = "posts")
public class Post {

    @Id
    private String id;

    private LocalDate createdAt;
    private String title;
    private String body;
    private AuthorDTO author;

    private List<CommentDTO> comments = new ArrayList<>();

    public Post(String id, LocalDate createdAt, String title, String body, AuthorDTO author) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Post post)) return false;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
