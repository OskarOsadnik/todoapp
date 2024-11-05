package com.example.todoapp.Task;

import java.util.List;

public interface TaskService {

    List<Task> getTask();
    void addNewTask(Task task);
    void deleteTask(Long taskId);
    void updateTask(Long taskId, Task updatedTask);
}
