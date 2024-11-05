package com.example.todoapp.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Component
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {this.taskRepository = taskRepository;}

    // GET
    public List<com.example.todoapp.Task.Task> getTask() {
        return taskRepository.findAll();
    }

    // POST
    public void addNewTask(com.example.todoapp.Task.Task task) {
        taskRepository.save(task);
    }

    // DELETE
    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists) {
            throw new IllegalArgumentException("Task with id " + taskId + " does not exist");
        }
        taskRepository.deleteById(taskId);
    }

    // PUT
    @Transactional
    public void updateTask(Long taskId, Task updatedTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalStateException("Task with id " + taskId + "does not exists"));

        if (updatedTask == null){
            throw new IllegalArgumentException("Updated user cannot be null");
        }

        if (updatedTask.getTitle() != null && !updatedTask.getTitle().isEmpty() && !Objects.equals(task.getTitle(), updatedTask.getTitle())) {
            task.setTitle(updatedTask.getTitle());
        }

        if(updatedTask.getContent() != null && !updatedTask.getContent().isEmpty() && !Objects.equals(task.getContent(), updatedTask.getContent())) {
            task.setContent(updatedTask.getContent());
        }

        if(updatedTask.getAuthorId() != 0 && !Objects.equals(task.getAuthorId(), updatedTask.getAuthorId())) {
            task.setAuthorId(updatedTask.getAuthorId());
        }

        taskRepository.save(task);

    }

}
