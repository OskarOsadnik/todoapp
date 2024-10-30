package com.example.todoapp.Comment;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentServiceImpl implements CommentService {

    private final CommentRepository comments_repository;

    @Autowired
    public CommentServiceImpl(CommentRepository comments_repository) {this.comments_repository = comments_repository;}

    // GET
    public List<Comment> get_comment() {
        return comments_repository.findAll();
    }

    // POST
    public void add_new_comment(Comment comment) {
        comments_repository.save(comment);
    }

    // DELETE
    public void delete_comment(Long comment_id) {
        boolean exists = comments_repository.existsById(comment_id);
        if (!exists) {
            throw new IllegalArgumentException("Comment with id " + comment_id + " does not exist");
        }
        comments_repository.deleteById(comment_id);
    }

    // PUT
    @Transactional
    public void update_comment(Long comment_id) {
        Comment comment = comments_repository.findById(comment_id).orElseThrow(() -> new IllegalStateException("Comment with id " + comment_id + " does not exists"));
    }

}
