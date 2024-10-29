package com.example.todoapp.Tasks;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TasksServiceImpl implements TasksService {

    private final TasksRepository tasks_repository;

    @Autowired
    public TasksServiceImpl(TasksRepository tasks_repository) {this.tasks_repository = tasks_repository;}
    public List<Tasks> get_tasks() {
        return tasks_repository.findAll();
    }

    // Dodaje nowego taska
    public void add_new_task(Tasks task) {
        tasks_repository.save(task);
    }

    // Usuwa taska chyba że nie istnieje
    public void delete_task(Long task_id) {
        boolean exists = tasks_repository.existsById(task_id);
        if (!exists) {
            throw new IllegalArgumentException("Task with id " + task_id + " does not exist");
        }
        tasks_repository.deleteById(task_id);
    }

    @Transactional
    public void update_task(Long task_id) {
        Tasks tasks = tasks_repository.findById(task_id).orElseThrow(() -> new IllegalStateException("Task with id " + task_id + "does not exists"));

    }

}
