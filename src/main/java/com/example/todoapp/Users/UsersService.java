package com.example.todoapp.Users;

import java.util.List;

public interface UsersService {

    List<Users> get_users();
    void add_new_user(Users user);
    void delete_user(Long user_id);
    void update_user(Long user_id, String name, String login);

}
