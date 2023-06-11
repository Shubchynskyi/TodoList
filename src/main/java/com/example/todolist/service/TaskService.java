package com.example.todolist.service;

import com.example.todolist.dao.TaskDAO;
import com.example.todolist.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskDAO taskDAO;

    public Page<Task> findAll(Pageable pageable) {
        return taskDAO.findAll(pageable);
    }

    public void createOrUpdateTask(Task task) {
        taskDAO.save(task);
    }

    public void deleteTaskById(Long id) {
        taskDAO.deleteById(id);
    }


}
