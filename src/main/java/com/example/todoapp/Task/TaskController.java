package com.example.todoapp.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTask() {
        return taskService.getTask();
    }

    @PostMapping
    public Map<String, List<Task>> createTask(@RequestBody Task task) {
        taskService.addNewTask(task);
        return Map.of("Task added to database:", List.of(task));
    }

    @DeleteMapping(path = "{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable("taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted from database");
    }

    @PutMapping(path = "{taskId}")
    public ResponseEntity<String> updateTask(@RequestBody Task task, @PathVariable("taskId") Long taskId) {
        taskService.updateTask(taskId, task);
        return ResponseEntity.ok("Task updated from database");
    }
}
