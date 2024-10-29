package com.example.todoapp.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/comments")
public class CommentsController {

    private final CommentsServiceImpl comments_service;

    @Autowired
    public CommentsController(CommentsServiceImpl comments_service) {
        this.comments_service = comments_service;
    }

    @GetMapping
    public List<Comments> get_comments() {
        return comments_service.get_comments();
    }

    @PostMapping
    public void create_comment(@RequestBody Comments comment) {
        comments_service.add_new_comment(comment);
    }

    @DeleteMapping(path = "{comment_id}")
    public void delete_comment(@PathVariable("comment_id") Long comment_id) {
        comments_service.delete_comment(comment_id);
    }

    @PutMapping(path = "{comment_id}")
    public void update_comment(@PathVariable("comment_id") Long comment_id) {
        comments_service.update_comment(comment_id);
    }
}
