// Controller, part of Spring JPA, handles HTTP requests, processing and returning appropriate responses

package com.danthony.exercise.controllers;

import com.danthony.exercise.entities.Task;
import com.danthony.exercise.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // Initial message
    @GetMapping("/")
    public String welcome() {
        return "Welcome to the Task Management App!";
    }

    // Show all task records
    @GetMapping("/task")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Get task by taskId
    @GetMapping("/task/{taskId}")
    public Task getTaskById(@PathVariable(name = "taskId") int taskId) {
        return taskRepository.findTaskByTaskId(taskId);
    }

    // Add a task
    @PostMapping("/task/add")
    public Task createNewTask(@RequestBody Task newTask) {
        return taskRepository.save(newTask);
    }

    // Delete a task by taskId
    @DeleteMapping("/task/delete/{taskId}")
    public void deleteTaskById(@PathVariable int taskId) {
        Task task = taskRepository.findTaskByTaskId(taskId);
        taskRepository.delete(task);
    }
}