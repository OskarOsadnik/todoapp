package com.example.todoapp.Comment;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@Entity
@Table
public class Comment {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    private int commentId;
    private String title;
    private String content;
    private int authorId;
    private int parentId;
    private int taskId;

    public Comment() {}

}
