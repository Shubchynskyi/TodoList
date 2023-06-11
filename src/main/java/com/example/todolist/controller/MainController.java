package com.example.todolist.controller;

import com.example.todolist.entity.Status;
import com.example.todolist.entity.Task;
import com.example.todolist.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class MainController {

    private final TaskService taskService;

    @ModelAttribute("statuses")
    public Status[] statuses() {
        return Status.values();
    }

    @GetMapping("/")
    public String taskList(
            Model model,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit
    ) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("id").descending());
        Page<Task> tasksPage = taskService.findAll(pageable);

        int totalPages = tasksPage.getTotalPages();
        if (page >= totalPages) {
            page = Math.max(totalPages - 1, 0);
            pageable = PageRequest.of(page, limit, Sort.by("id").descending());
            tasksPage = taskService.findAll(pageable);
        }

        model.addAttribute("tasksPage", tasksPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("currentLimit", limit);
        model.addAttribute("task", new Task());
        List<Integer> limits = Arrays.asList(10, 15, 20, 25, 50);
        model.addAttribute("limits", limits);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(
            @ModelAttribute Task task,
            @RequestParam(value = "page", required = false, defaultValue = "0") Optional<Integer> page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Optional<Integer> limit
    ) {
        task.setStatus(Status.IN_PROGRESS);
        taskService.createOrUpdateTask(task);
        return "redirect:/?page=" + page.orElse(0) + "&limit=" + limit.orElse(10);
    }

    @PatchMapping("/edit/{id}")
    public String editTask(
            @ModelAttribute Task task,
            @RequestParam(value = "page", required = false, defaultValue = "0") Optional<Integer> page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Optional<Integer> limit
    ) {
        taskService.createOrUpdateTask(task);
        return "redirect:/?page=" + page.orElse(0) + "&limit=" + limit.orElse(10);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTask(
            @PathVariable("id") Long taskId,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") int limit
    ) {
        taskService.deleteTaskById(taskId);
        return "redirect:/?page=" + page + "&limit=" + limit;
    }

}
