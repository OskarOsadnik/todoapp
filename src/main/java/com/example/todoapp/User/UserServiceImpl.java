package com.example.todoapp.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {this.userRepository = userRepository;}

    // GET
    public List<User> getUser() {
        return userRepository.findAll();
    }

    // POST
    public void addNewUser(User user) {
        PasswordEncryptor passwordEncryptor = new PasswordEncryptor();
        Optional<User> userOptional = userRepository.findByLogin(user.getLogin());
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getLogin() + " already exists");
        }
        user.setPassword(passwordEncryptor.encrypt(user.getPassword()));
        user.setCreationDate(LocalDate.now());
        userRepository.save(user);
    }

    // DELETE
    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (!exists) {
            throw new IllegalArgumentException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }


    // PUT
    @Transactional
    public void updateUser(Long userId, String login, String password, String name, String surname, String birthday) {
     User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + "does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if(login != null && login.length() > 0 && !Objects.equals(user.getLogin(), login)) {
            Optional<User> userOptional = userRepository.findByLogin(login);
            if (userOptional.isPresent()) {
                throw new IllegalArgumentException("Login " + login + " already exists");
            }
            user.setLogin(login);
        }

        if(password != null && password.length() > 0 && !Objects.equals(user.getPassword(), password)) {
            user.setPassword(password);
        }

        if(surname != null && surname.length() > 0 && !Objects.equals(user.getSurname(), surname)) {
            user.setSurname(surname);
        }

        if(birthday != null && birthday.length() > 0 && !Objects.equals(user.getBirthday(), birthday)) {
            user.setBirthday(birthday);
        }

        userRepository.save(user);


    }

}
