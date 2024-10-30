package com.example.todoapp.User;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int user_id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int privileges;
    private String birthday;
    private LocalDate creation_date;

    public User(int user_id, String login, String password, String name, String surname, int privileges, String birthday) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.privileges = privileges;
        this.birthday = birthday;
    }

    public User() {}

}
