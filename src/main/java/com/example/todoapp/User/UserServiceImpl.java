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
    public void updateUser(Long userId, User updatedUser) {
     User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id " + userId + "does not exists"));

        if (updatedUser == null){
            throw new IllegalArgumentException("Updated user cannot be null");
        }

        if (updatedUser.getName() != null && !updatedUser.getName().isEmpty() && !Objects.equals(user.getName(), updatedUser.getName())) {
            user.setName(updatedUser.getName());
        }

        if(updatedUser.getLogin() != null && !updatedUser.getLogin().isEmpty() && !Objects.equals(user.getLogin(), updatedUser.getLogin())) {
            Optional<User> userOptional = userRepository.findByLogin(updatedUser.getLogin());
            if (userOptional.isPresent()) {
                throw new IllegalArgumentException("Login " + updatedUser.getLogin() + " already exists");
            }
            user.setLogin(updatedUser.getLogin());
        }

        if(updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty() && !Objects.equals(user.getPassword(), updatedUser.getPassword())) {
            user.setPassword(updatedUser.getPassword());
        }

        if(updatedUser.getSurname() != null && !updatedUser.getSurname().isEmpty() && !Objects.equals(user.getSurname(), updatedUser.getSurname())) {
            user.setSurname(updatedUser.getSurname());
        }

        if(updatedUser.getBirthday() != null && !updatedUser.getBirthday().isEmpty() && !Objects.equals(user.getBirthday(), updatedUser.getBirthday())) {
            user.setBirthday(updatedUser.getBirthday());
        }

        userRepository.save(user);

    }

}
