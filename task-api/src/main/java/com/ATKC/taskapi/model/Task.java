package com.ATKC.taskapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @Entity Create database table
 * @Table Name the table tasks
 */
@Entity
@Table(name = "tasks")
public class Task {

    /**
     * @Id Primary key
     * @GeneratedValue Database to auto generate/set ID value
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    /**
     * @Column Maps field to database column, field cannot be null
     */
    @Column(nullable = false)
    private String title;

    private String description;

    /**
     * @Enumerated Storing enum fields as string
     */
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime createdAt; // Timestamps
    private LocalDateTime updatedAt;

    public Task(Long ID, String title, String description, TaskStatus status, LocalDateTime createdAt, LocalDateTime updateAt) {

        this.ID = ID;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updateAt;

    }

    public Long getID() {

        return ID;

    }

    public void setID(Long ID) {

        this.ID = ID;

    }

    public String getTitle() {

        return title;

    }

    public void setTitle(String title) {

        this.title = title;

    }

    public String getDescription() {

        return description;

    }

    public void setDescription(String description) {

        this.description = description;

    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {

        return createdAt;

    }

    public void setCreatedAt(LocalDateTime createdAt) {

        this.createdAt = createdAt;

    }

    public LocalDateTime getUpdatedAt() {

        return updatedAt;

    }

    public void setUpdatedAt(LocalDateTime updatedAt) {

        this.updatedAt = updatedAt;

    }

}
