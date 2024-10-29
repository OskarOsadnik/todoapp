package com.example.todoapp.Users;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {


    private final UsersRepository users_repository;

    @Autowired
    public UsersServiceImpl(UsersRepository users_repository) {this.users_repository = users_repository;}

    public List<Users> get_users() {
        return users_repository.findAll();
    }

    // Dodaje nowego usera
    public void add_new_user(Users user) {
        Optional<Users> usersOptional = users_repository.find_by_login(user.getLogin());
        if (usersOptional.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getLogin() + " already exists");
        }
        users_repository.save(user);
    }

    // Usuwa usera chyba że nie istnieje
    public void delete_user(Long user_id) {
        boolean exists = users_repository.existsById(user_id);
        if (!exists) {
            throw new IllegalArgumentException("User with id " + user_id + " does not exist");
        }
        users_repository.deleteById(user_id);
    }


    @Transactional
    public void update_user(Long user_id, String name, String login) {
        Users users = users_repository.findById(user_id).orElseThrow(() -> new IllegalStateException("User with id " + user_id + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(users.getName(), name)) {
            users.setName(name);
        }

        if(login != null && login.length() > 0 && !Objects.equals(users.getLogin(), login)) {
            Optional<Users> usersOptional = users_repository.find_by_login(login);
            if (usersOptional.isPresent()) {
                throw new IllegalArgumentException("Login " + login + " already exists");
            }
            users.setLogin(login);
        }
    }
}
