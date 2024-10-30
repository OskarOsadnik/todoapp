package com.example.todoapp.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskServiceImpl task_service;

    @Autowired
    public TaskController(TaskServiceImpl task_service) {
        this.task_service = task_service;
    }

    @GetMapping
    public List<Task> get_task() {
        return task_service.get_task();
    }

    @PostMapping
    public Map<String, List<Task>> create_task(@RequestBody Task task) {
        task_service.add_new_task(task);
        return Map.of("Task added to database:", List.of(task));
    }

    @DeleteMapping(path = "{task_id}")
    public ResponseEntity<String> delete_task(@PathVariable("task_id") Long task_id) {
        task_service.delete_task(task_id);
        return ResponseEntity.ok("Task deleted from database");
    }

    @PutMapping(path = "{task_id}")
    public void update_task(@PathVariable("task_id") Long task_id) {
        task_service.update_task(task_id);
    }
}
