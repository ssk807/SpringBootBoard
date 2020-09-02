package com.example.boarddemo.Contorller;

import com.example.boarddemo.entity.Post;
import com.example.boarddemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

    @Autowired
    PostRepository repository;

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/post")
    public List<Post> getAllPost() {
        return repository.findAll();
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable String id) {
        Long postId = Long.parseLong(id);

        Optional<Post> byId = repository.findById(postId);

        return byId.get();
    }

    @PutMapping("/post")
    public Post createPost(@RequestBody Post post) {
        Post save = repository.save(post);

        return save;
    }

    @PostMapping("/post/{id}")
    public Post updatePost(@PathVariable String id, @RequestBody Post newPost) {
        Long postId = Long.parseLong(id);
        Optional<Post> byId = repository.findById(postId);

        byId.get().setTitle(newPost.getTitle());
        byId.get().setContent(newPost.getContent());

        Post save = repository.save(newPost);

        return newPost;
    }


    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable String id) {
        Long postId = Long.parseLong(id);
        repository.deleteById(postId);

        return "Delete Success!";
    }
}
