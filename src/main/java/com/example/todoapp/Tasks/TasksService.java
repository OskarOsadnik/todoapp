package com.example.todoapp.Tasks;

import java.util.List;

public interface TasksService {

    List<Tasks> get_tasks();
    void add_new_task(Tasks task);
    void delete_task(Long task_id);
    void update_task(Long task_id);

}
