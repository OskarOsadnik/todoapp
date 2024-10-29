package com.example.todoapp.Tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TasksRepository extends JpaRepository<Tasks, Long>{

        @Query("SELECT s FROM Tasks s WHERE s.task_id = ?1")
        Optional<Tasks> find_by_task_id(String task_id);
}
