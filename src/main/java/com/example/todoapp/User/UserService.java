package com.example.todoapp.User;

import java.util.List;

public interface UserService {

    List<User> getUser();
    void addNewUser(User user);
    void deleteUser(Long userId);
    void updateUser(Long userId, User user);

}
