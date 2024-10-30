package com.example.todoapp.Task;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskServiceImpl implements TaskService {

    private final TaskRepository task_repository;

    @Autowired
    public TaskServiceImpl(TaskRepository task_repository) {this.task_repository = task_repository;}

    // GET
    public List<Task> get_task() {
        return task_repository.findAll();
    }

    // POST
    public void add_new_task(Task task) {
        task_repository.save(task);
    }

    // DELETE
    public void delete_task(Long task_id) {
        boolean exists = task_repository.existsById(task_id);
        if (!exists) {
            throw new IllegalArgumentException("Task with id " + task_id + " does not exist");
        }
        task_repository.deleteById(task_id);
    }

    // PUT
    @Transactional
    public void update_task(Long task_id) {
        Task task = task_repository.findById(task_id).orElseThrow(() -> new IllegalStateException("Task with id " + task_id + "does not exists"));
    }

}
