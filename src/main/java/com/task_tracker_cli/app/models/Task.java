package com.task_tracker_cli.app.models;


import com.task_tracker_cli.app.misc.Status;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task {

    private int id;

    public static int lastId = 0;

    private String description;

    private Status status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;


    public Task(String description) {
        this.id = ++lastId;
        this.description = description;
        this.status = Status.TODO;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Task.lastId = lastId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public void markInProgress(){
        this.status = Status.IN_PROGRESS;
        this.updatedAt = LocalDateTime.now();
    }

    public void markDone(){
        this.status = Status.DONE;
        this.updatedAt = LocalDateTime.now();
    }

    public void updateDescription(String description) {
        this.description = description;
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id: " + id +
                ", description: '" + description.strip() + '\'' +
                ", status: " + status.toString() +
                ", createdAt: " + createdAt.format(formatter) +
                ", updatedAt: " + updatedAt.format(formatter) +
                '}';
    }
}
