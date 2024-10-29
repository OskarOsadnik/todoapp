package com.example.todoapp.Comments;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Comments {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int comment_id;
    private String content;
    private int author_id;
    private int parent_id;
    private String creation_date;
    private int task_id;

    // Constructor
    public Comments(int comment_id, String content, int author_id, int parent_id, String creation_date, int task_id) {
        this.comment_id = comment_id;
        this.content = content;
        this.author_id = author_id;
        this.parent_id = parent_id;
        this.creation_date = creation_date;
        this.task_id = task_id;
    }

    public Comments() {}

}
