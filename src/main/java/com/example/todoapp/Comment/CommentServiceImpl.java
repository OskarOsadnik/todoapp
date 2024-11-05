package com.example.todoapp.Comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Component
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {this.commentRepository = commentRepository;}

    // GET
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    // POST
    public void addNewComment(Comment comment) {
        commentRepository.save(comment);
    }

    // DELETE
    public void deleteComment(Long commentId) {
        boolean exists = commentRepository.existsById(commentId);
        if (!exists) {
            throw new IllegalArgumentException("Comment with id " + commentId + " does not exist");
        }
        commentRepository.deleteById(commentId);
    }

    // PUT
    @Transactional
    public void updateComment(Long commentId, Comment updatedComment) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalStateException("Comment with id " + commentId + "does not exists"));

        if (updatedComment == null){
            throw new IllegalArgumentException("Updated comment cannot be null");
        }

        if (updatedComment.getTitle() != null && !updatedComment.getTitle().isEmpty() && !Objects.equals(comment.getTitle(), updatedComment.getTitle())) {
            comment.setTitle(updatedComment.getTitle());
        }

        if(updatedComment.getContent() != null && !updatedComment.getContent().isEmpty() && !Objects.equals(comment.getContent(), updatedComment.getContent())) {
            comment.setContent(updatedComment.getContent());
        }

        if(updatedComment.getAuthorId() != 0 && !Objects.equals(comment.getAuthorId(), updatedComment.getAuthorId())) {
            comment.setAuthorId(updatedComment.getAuthorId());
        }

        if(updatedComment.getParentId() != 0 && !Objects.equals(comment.getParentId(), updatedComment.getParentId())) {
            comment.setParentId(updatedComment.getParentId());
        }

        if(updatedComment.getTaskId() != 0 && !Objects.equals(comment.getTaskId(), updatedComment.getTaskId())) {
            comment.setTaskId(updatedComment.getTaskId());
        }
        commentRepository.save(comment);

    }

}
