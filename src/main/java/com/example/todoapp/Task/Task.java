package com.example.todoapp.Task;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int task_id;
    private String title;
    private String content;
    private int author_id;
    private String creation_date;

    public Task(int task_id, String title, String content, int author_id, String creation_date) {
        this.task_id = task_id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
        this.creation_date = creation_date;
    }

    public Task() {}

}
