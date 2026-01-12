package com.ATKC.taskapi.service;

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

        Task newTask = repository.save(task);
        return newTask;

    }

    @Override
    public void deleteTask(Long taskID) {

        repository.deleteById(taskID);

    }

    @Override
    public List<Task> getAllTasks() {

        List<Task> savedTasks = repository.findAll();
        return savedTasks;

    }

    @Override
    public Task getTaskByID(Long taskID) {

        Task task = repository.findById(taskID).orElseThrow();
        return task;

    }

    @Override
    public Task updateTask(Task task) {

        Task updatedTask = repository.save(task);
        return updatedTask;

    }

    @Override
    public boolean updateTaskStatus(Long taskID, TaskStatus newStatus) {

        boolean statusUpdated = false;
        Task newTask = getTaskByID(taskID); // get task ID

        if (newTask != null) { // check if task ID exist

            newTask.setStatus(newStatus); // update status
            statusUpdated = true;

            // update repository
            repository.save(newTask);

        }

        return statusUpdated;

    }



}
