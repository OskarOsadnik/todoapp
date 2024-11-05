package com.example.todoapp.Task;

import jakarta.persistence.*;
import lombok.*;



@Data
@AllArgsConstructor
@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int taskId;
    private String title;
    private String content;
    private int authorId;

    public Task() {}

}
