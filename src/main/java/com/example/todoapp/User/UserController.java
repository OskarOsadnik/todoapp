package com.example.todoapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @PostMapping
    public Map<String, List<User>> registerUser(@RequestBody User user) {
        userService.addNewUser(user);
        return Map.of("User added to database:", List.of(user));
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted from database");
    }

    @PutMapping(path = "{userId}")
    public void updateUser(@RequestBody User user,@PathVariable("userId") Long userId, @RequestParam(required = false) String name, @RequestParam(required = false) String login, @RequestParam(required = false) String password, @RequestParam(required = false) String surname, @RequestParam(required = false) String birthday ) {
        userService.updateUser(userId, name, login, password, surname, birthday);
    }

}
