package com.example.boarddemo.Contorller;

import com.example.boarddemo.entity.Post;
import com.example.boarddemo.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class PostControllerTest {
    @Autowired
    PostRepository repository;


    @Test
    public void di(){
        Post post1 = new Post();
        post1.setTitle("test");
        post1.setContent("test");
        post1.setId(Long.parseLong("14"));

        Post post2 = new Post();
        post2.setTitle("test");
        post2.setContent("test");
        post2.setId(Long.parseLong("14"));

        Post save = repository.save(post1);

        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> repository.save(post2));

    }
}