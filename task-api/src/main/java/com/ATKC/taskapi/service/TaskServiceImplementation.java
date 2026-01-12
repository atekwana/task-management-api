package com.ATKC.taskapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ATKC.taskapi.model.Task;
import com.ATKC.taskapi.model.TaskStatus;
import com.ATKC.taskapi.repository.TaskRepository;

@Service
public class TaskServiceImplementation implements TaskService {

    TaskRepository repository;

    public TaskServiceImplementation(TaskRepository repository) {

        this.repository = repository;

    }

    @Override
    public Task createTask(Task task) {

        task.setCreatedAt(LocalDateTime.now());
        task.setUpdatedAt(LocalDateTime.now());
        return repository.save(task);

    }

    @Override
    public void deleteTask(Long taskID) {

        repository.deleteById(taskID);

    }

    @Override
    public List<Task> getAllTasks() {

        return repository.findAll();

    }

    @Override
    public Task getTaskByID(Long taskID) {

        return repository.findById(taskID).orElseThrow();

    }

    @Override
    public Task updateTask(Task task) {

        task.setUpdatedAt(LocalDateTime.now());
        return repository.save(task);

    }

    @Override
    public boolean updateTaskStatus(Long taskID, TaskStatus newStatus) {

        Task newTask = getTaskByID(taskID);

        newTask.setStatus(newStatus);
        newTask.setUpdatedAt(LocalDateTime.now());
        repository.save(newTask);

        return true;

    }

}
