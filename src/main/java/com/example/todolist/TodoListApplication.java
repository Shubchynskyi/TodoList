package com.example.todolist;

import com.example.todolist.entity.Status;
import com.example.todolist.entity.Task;
import com.example.todolist.service.TaskService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodoListApplication {


    public static void main(String[] args) {
        var context = SpringApplication.run(TodoListApplication.class, args);

        TaskService taskService = context.getBean(TaskService.class);

        Task task = Task.builder()
                .description("New task number 1")
                .status(Status.IN_PROGRESS)
                .build();

        System.out.println(task);

        Task savedTask = taskService.createOrUpdateTask(task);
        System.out.println(savedTask);

        taskService.deleteTask(task);

        taskService.findAll().forEach(System.out::println);

    }

}
