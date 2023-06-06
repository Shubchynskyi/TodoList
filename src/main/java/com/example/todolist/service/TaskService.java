package com.example.todolist.service;

import com.example.todolist.dao.TaskDAO;
import com.example.todolist.entity.Task;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskDAO taskDAO;

    public List<Task> findAll(){
        return taskDAO.findAll();
    }

    public Page<Task> findAll(Pageable pageable){
        return taskDAO.findAll(pageable);
    }

    public Task createOrUpdateTask(Task task) {
        return taskDAO.save(task);
    }

    public void deleteTask(Task task) {
        taskDAO.delete(task);
    }

    public void deleteTaskById(Long id) {
        taskDAO.deleteById(id);
    }


}
