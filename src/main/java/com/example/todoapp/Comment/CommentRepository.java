package com.example.todoapp.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT s FROM Comment s WHERE s.comment_id = ?1")
    Optional<Comment> find_by_comment_id(String comment_id);
}