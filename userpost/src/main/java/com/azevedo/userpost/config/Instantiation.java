package com.azevedo.userpost.config;

import com.azevedo.userpost.domain.Post;
import com.azevedo.userpost.domain.User;
import com.azevedo.userpost.dto.AuthorDTO;
import com.azevedo.userpost.dto.CommentDTO;
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

        User luana = new User(null, "Luana Silva", "luana@gmail.com");
        User bruno = new User(null, "Bruno Victor", "bruno@gmail.com");
        User lucas = new User(null, "Lucas Santos", "lucas@gmail.com");

        userRepository.saveAll(Arrays.asList(luana, bruno, lucas));

        Post post1 = new Post(null, LocalDate.parse("21/03/2026", formatter),
                "Viagem para São Paulo", "Viagem para São Paulo marcada! Dicas de restaurantes e passeios são bem-vindas.", new AuthorDTO(luana));

        Post post2 = new Post(null, LocalDate.parse("23/03/2026", formatter),
                "Bom dia", "Acordei feliz hoje!", new AuthorDTO(luana));

        CommentDTO c1 = new CommentDTO("Recomendo visitar a Avenida Paulista e o Parque Ibirapuera!!", LocalDate.parse("21/03/2026", formatter), new AuthorDTO(bruno));
        CommentDTO c2 = new CommentDTO("Se puder, passa no Mercado Municipal. Vale muito a pena!", LocalDate.parse("22/03/2026", formatter), new AuthorDTO(lucas));
        CommentDTO c3 = new CommentDTO("Fica de olho no trânsito, especialmente em horário de pico.", LocalDate.parse("23/03/2026", formatter), new AuthorDTO(bruno));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        luana.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(luana);
    }
}
