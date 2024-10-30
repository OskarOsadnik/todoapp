package com.example.todoapp.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

    private final CommentServiceImpl comment_service;

    @Autowired
    public CommentController(CommentServiceImpl comment_service) {
        this.comment_service = comment_service;
    }

    @GetMapping
    public List<Comment> get_comment() {
        return comment_service.get_comment();
    }

    @PostMapping
    public Map<String, List<Comment>> create_comment(@RequestBody Comment comment) {
        comment_service.add_new_comment(comment);
        return Map.of("Comment added to database:", List.of(comment));
    }

    @DeleteMapping(path = "{comment_id}")
    public ResponseEntity<String> delete_comment(@PathVariable("comment_id") Long comment_id) {
            comment_service.delete_comment(comment_id);
            return ResponseEntity.ok("Comment deleted from database");
    }

    @PutMapping(path = "{comment_id}")
    public void update_comment(@PathVariable("comment_id") Long comment_id) {
        comment_service.update_comment(comment_id);
    }
}
