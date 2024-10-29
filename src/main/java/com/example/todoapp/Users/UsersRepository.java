package com.example.todoapp.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    @Query("SELECT s FROM Users s WHERE s.login = ?1")
    Optional<Users> find_by_login(String login);
}
