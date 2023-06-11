package com.example.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TodoListApplication {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        var context = SpringApplication.run(TodoListApplication.class, args);

    }
}
