package com.example.todoapp.Users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table      // Powoduje że klasa "Users" będzie tabelą w bazie danych
public class Users {

    @Id // Oznacza że wartość "private int user_id;" będzię wartością id w bazie danych
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private int user_id;
    private String login;
    private String password;
    private String name;
    private String surname;
    private int privileges;
    private String birthday;

    // Constructor
    public Users(int user_id, String login, String password, String name, String surname, int privileges, String birthday) {
        this.user_id = user_id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.privileges = privileges;
        this.birthday = birthday;
    }

    public Users() {}

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", privileges=" + privileges +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
