package com.example.boarddemo.repository;

import com.example.boarddemo.entity.Comment;
import com.example.boarddemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findCommentsByPost(Post post);
}
