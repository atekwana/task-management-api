package com.ATKC.taskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ATKC.taskapi.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
