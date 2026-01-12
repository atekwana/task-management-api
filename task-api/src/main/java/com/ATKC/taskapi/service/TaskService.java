package com.ATKC.taskapi.service;

import java.util.List;

import com.ATKC.taskapi.model.Task;
import com.ATKC.taskapi.model.TaskStatus;

public interface TaskService {

    // C.R.U.D
    public Task createTask(Task task); // Create task

    public List<Task> getAllTasks(); // Review all tasks

    public Task getTaskByID(Long taskID); // Review task by ID

    public Task updateTask(Task task); // Update task

    public boolean updateTaskStatus(Long taskID, TaskStatus status); // Update task status

    public void deleteTask(Long taskID); // Delete tasks

}
