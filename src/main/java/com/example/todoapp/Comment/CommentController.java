package com.example.todoapp.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/comment")
public class CommentController {

    private final CommentServiceImpl commentService;

    @Autowired
    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getComment() {
        return commentService.getComment();
    }

    @PostMapping
    public Map<String, List<Comment>> createComment(@RequestBody Comment comment) {
        commentService.addNewComment(comment);
        return Map.of("Comment added to database:", List.of(comment));
    }

    @DeleteMapping(path = "{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable("commentId") Long commentId) {
            commentService.deleteComment(commentId);
            return ResponseEntity.ok("Comment deleted from database");
    }

    @PutMapping(path = "{commentId}")
    public void updateComment(@RequestBody Comment comment, @PathVariable("commentId") Long commentId) {
        commentService.updateComment(commentId, comment);
    }
}
