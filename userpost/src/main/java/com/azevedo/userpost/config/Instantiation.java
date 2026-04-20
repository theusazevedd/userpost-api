package com.azevedo.userpost.config;

import com.azevedo.userpost.domain.Post;
import com.azevedo.userpost.domain.User;
import com.azevedo.userpost.dto.AuthorDTO;
import com.azevedo.userpost.repository.PostRepository;
import com.azevedo.userpost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2023", formatter),
                "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));

        Post post2 = new Post(null, LocalDate.parse("23/03/2023", formatter),
                "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
