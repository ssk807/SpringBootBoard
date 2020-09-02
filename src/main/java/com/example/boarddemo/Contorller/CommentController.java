package com.example.boarddemo.Contorller;

import com.example.boarddemo.entity.Comment;
import com.example.boarddemo.entity.Post;
import com.example.boarddemo.repository.CommentRepository;
import com.example.boarddemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/post/{id}/comment")
    public List<Comment> getPostComments(@PathVariable Long id) {
        Post post = postRepository.findById(id).get();
        return commentRepository.findCommentsByPost(post);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/post/{id}/comment")
    public Comment createComment(@PathVariable Long id, @RequestBody Comment comment) {
        Optional<Post> byId = postRepository.findById(id);
        comment.setPost(byId.get());
        commentRepository.save(comment);
        return comment;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post/{id}/comment/{commentID}")
    public Comment updateComment(@PathVariable Long id, @PathVariable Long commentID, @RequestBody Comment comment) {
        Optional<Post> postById = postRepository.findById(id);
        comment.setPost(postById.get());
        Comment newComment = commentRepository.findById(commentID).get();
        newComment.setContent(comment.getContent());
        newComment.setTitle(comment.getTitle());
        newComment.setWriter(comment.getWriter());

        return newComment;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/post/{id}/comment/{commentID}")
    public String deleteComment(@PathVariable Long id, @PathVariable Long commentID) {
        commentRepository.deleteById(commentID);

        return "Comment Delete Success!";
    }
}
