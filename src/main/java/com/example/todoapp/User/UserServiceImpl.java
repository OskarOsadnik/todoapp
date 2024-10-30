package com.example.todoapp.User;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository user_repository;

    @Autowired
    public UserServiceImpl(UserRepository user_repository) {this.user_repository = user_repository;}

    // GET
    public List<User> get_user() {
        return user_repository.findAll();
    }

    // POST
    public void add_new_user(User user) {
        Optional<User> userOptional = user_repository.find_by_login(user.getLogin());

        // Sprawdza czy email jest już w użyciu
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getLogin() + " already exists");
        }

        // Metoda enkrypcji hasła
        String password = user.getPassword();
        StringBuilder encrypted_password = new StringBuilder();
        for (char character : password.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encrypted_password.append((char) ((character - base + 4) % 26 + base));
            } else if (Character.isDigit(character)) {
                encrypted_password.append((char) ((character - '0' + 8) % 10 + '0'));
            } else{encrypted_password.append(character);}
        }
        user.setCreation_date(LocalDate.now());
        user.setPassword(encrypted_password.toString());
        user_repository.save(user);
    }

    // DELETE
    public void delete_user(Long user_id) {
        boolean exists = user_repository.existsById(user_id);
        if (!exists) {
            throw new IllegalArgumentException("User with id " + user_id + " does not exist");
        }
        user_repository.deleteById(user_id);
    }

    // PUT
    @Transactional
    public void update_user(Long user_id, String name, String login) {
        User user = user_repository.findById(user_id).orElseThrow(() -> new IllegalStateException("User with id " + user_id + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if(login != null && login.length() > 0 && !Objects.equals(user.getLogin(), login)) {
            Optional<User> userOptional = user_repository.find_by_login(login);
            if (userOptional.isPresent()) {
                throw new IllegalArgumentException("Login " + login + " already exists");
            }
            user.setLogin(login);
        }
    }

}
