package com.example.todoapp.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComment();
    void addNewComment(Comment comment);
    void deleteComment(Long comment_id);

}
