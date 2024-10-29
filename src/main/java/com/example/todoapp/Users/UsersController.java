package com.example.todoapp.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// W tym pliku będą wszystke komendy RESTa (GET, POST, DELATE, PUT)

@RestController
@RequestMapping(path = "api/v1/users")
public class UsersController {

    private final UsersServiceImpl users_service;

    @Autowired
    public UsersController(UsersServiceImpl users_service) {
        this.users_service = users_service;
    }

    @GetMapping
    public List<Users> get_users() {
        return users_service.get_users();
    }

    @PostMapping
    public void register_user(@RequestBody Users user) {
        users_service.add_new_user(user);
    }

    @DeleteMapping(path = "{user_id}")
    public void delete_user(@PathVariable("user_id") Long user_id) {
        users_service.delete_user(user_id);
    }

    @PutMapping(path = "{user_id}")
    public void update_user(@PathVariable("user_id") Long user_id, @RequestParam(required = false) String name, @RequestParam(required = false) String login) {
        users_service.update_user(user_id, name, login);
    }
























//    @GetMapping
//    public List<Users> getUsers(Users users) {
//        List<Users> usersList = new ArrayList<>();
//        Users user1 = new Users(1, "o.osadnik@wasko.pl", "mojehaslo", "Oskar", "Osadnik", 1, "07-11-2006");
//        return usersList;
//
//    }
}
