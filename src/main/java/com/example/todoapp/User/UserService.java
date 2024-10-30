package com.example.todoapp.User;

import java.util.List;

public interface UserService {

    List<User> get_user();
    void add_new_user(User user);
    void delete_user(Long user_id);
    void update_user(Long user_id, String name, String login);

}
