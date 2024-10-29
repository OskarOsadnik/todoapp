package com.example.todoapp.Comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    @Query("SELECT s FROM Comments s WHERE s.comment_id = ?1")
    Optional<Comments> find_by_comment_id(String comment_id);
}