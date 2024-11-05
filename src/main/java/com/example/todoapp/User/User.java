package com.example.todoapp.User;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    private int userId;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int privileges;
    private String birthday;
    private LocalDate creationDate;


    public User() {}

}
