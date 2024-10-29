package com.example.todoapp.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TasksController {

    private final TasksServiceImpl tasks_service;

    @Autowired
    public TasksController(TasksServiceImpl tasks_service) {
        this.tasks_service = tasks_service;
    }

    @GetMapping
    public List<Tasks> get_tasks() {
        return tasks_service.get_tasks();
    }

    @PostMapping
    public void create_task(@RequestBody Tasks task) {
        tasks_service.add_new_task(task);
    }

    @DeleteMapping(path = "{task_id}")
    public void delete_task(@PathVariable("task_id") Long task_id) {
        tasks_service.delete_task(task_id);
    }

    @PutMapping(path = "{task_id}")
    public void update_task(@PathVariable("task_id") Long task_id) {
        tasks_service.update_task(task_id);
    }
}
