package com.ATKC.taskapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ATKC.taskapi.model.Task;
import com.ATKC.taskapi.model.TaskStatus;
import com.ATKC.taskapi.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {

        this.taskService = taskService;

    }

    @PostMapping
    public Task createTaskServiceEndpoints(@RequestBody Task task) {

        return taskService.createTask(task);

    }

    @GetMapping("{taskID}")
    public Task getSingleTaskServiceEndpoint(@PathVariable("taskID") Long taskID) {

        return taskService.getTaskByID(taskID);

    }

    @GetMapping
    public List<Task> getAllTaskServiceEndpoints() {

        return taskService.getAllTasks();

    }

    @PutMapping("{taskID}")
    public Task updateTaskEndpoints(@PathVariable("taskID") Long taskID, @RequestBody Task task) {

        task.setTaskID(taskID);
        return taskService.updateTask(task);

    }

    @PatchMapping("{taskID}/status")
    public boolean updateTaskStatusEndpoints(@PathVariable("taskID") Long taskID, @RequestParam String newStatus) {

        return taskService.updateTaskStatus(taskID, TaskStatus.valueOf(newStatus.toUpperCase()));

    }

    @DeleteMapping("{taskID}")
    public void deleteTaskEndpoints(@PathVariable("taskID") Long taskID) {

        taskService.deleteTask(taskID);

    }

}
