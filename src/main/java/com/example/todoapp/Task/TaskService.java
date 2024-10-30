package com.example.todoapp.Task;

import java.util.List;

public interface TaskService {

    List<Task> get_task();
    void add_new_task(Task task);
    void delete_task(Long task_id);
    void update_task(Long task_id);

}
