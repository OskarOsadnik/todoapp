package com.example.todoapp.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long>{
        @Query("SELECT s FROM Task s WHERE s.task_id = ?1")
        Optional<Task> find_by_task_id(String task_id);
}
