package com.example.todoapp.Comments;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentsServiceImpl implements CommentsService {

    private final CommentsRepository comments_repository;

    @Autowired
    public CommentsServiceImpl(CommentsRepository comments_repository) {this.comments_repository = comments_repository;}
    public List<Comments> get_comments() {
        return comments_repository.findAll();
    }

    // Dodaje nowego taska
    public void add_new_comment(Comments comment) {
        comments_repository.save(comment);
    }

    // Usuwa taska chyba że nie istnieje
    public void delete_comment(Long comment_id) {
        boolean exists = comments_repository.existsById(comment_id);
        if (!exists) {
            throw new IllegalArgumentException("Task with id " + comment_id + " does not exist");
        }
        comments_repository.deleteById(comment_id);
    }


    @Transactional
    public void update_comment(Long comment_id) {
        Comments comment = comments_repository.findById(comment_id).orElseThrow(() -> new IllegalStateException("Task with id " + comment_id + "does not exists"));

    }


}
