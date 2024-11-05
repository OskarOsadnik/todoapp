package com.example.todoapp.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")

    @NonNull
    private int userId;
    @NonNull
    private String login;
    @NonNull
    private String password;
    @NonNull
    private String name;
    @NonNull
    private String surname;
    @NonNull
    private int privileges;
    @NonNull
    private String birthday;
    @NonNull
    private LocalDate creationDate;

    public User(int userId, @NonNull String login, @NonNull String password, @NonNull String name, @NonNull String surname, int privileges, @NonNull String birthday) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.privileges = privileges;
        this.birthday = birthday;
    }

    public User() {}

}
