package com.example.todoapp.Comments;

import java.util.List;

public interface CommentsService {

    List<Comments> get_comments();
    void add_new_comment(Comments comment);
    void delete_comment(Long comment_id);
    void update_comment(Long comment_id);

}
