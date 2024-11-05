package com.example.todoapp.Task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long>{
        Optional<Task> findByTaskId(int taskId);
}
