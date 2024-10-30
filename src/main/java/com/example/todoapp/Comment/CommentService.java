package com.example.todoapp.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> get_comment();
    void add_new_comment(Comment comment);
    void delete_comment(Long comment_id);
    void update_comment(Long comment_id);

}
