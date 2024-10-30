package com.example.todoapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserServiceImpl user_service;

    @Autowired
    public UserController(UserServiceImpl user_service) {
        this.user_service = user_service;
    }

    @GetMapping
    public List<User> get_user() {
        return user_service.get_user();
    }

    @PostMapping
    public Map<String, List<User>> register_user(@RequestBody User user) {
        user_service.add_new_user(user);
        return Map.of("User added to database:", List.of(user));
    }

    @DeleteMapping(path = "{user_id}")
    public ResponseEntity<String> delete_user(@PathVariable("user_id") Long user_id) {
        user_service.delete_user(user_id);
        return ResponseEntity.ok("User deleted from database");
    }

    @PutMapping(path = "{user_id}")
    public void update_user(@PathVariable("user_id") Long user_id, @RequestParam(required = false) String name, @RequestParam(required = false) String login) {
        user_service.update_user(user_id, name, login);
    }
























//    @GetMapping
//    public List<Users> getUsers(Users users) {
//        List<Users> usersList = new ArrayList<>();
//        Users user1 = new Users(1, "o.osadnik@wasko.pl", "mojehaslo", "Oskar", "Osadnik", 1, "07-11-2006");
//        return usersList;
//
//    }
}
