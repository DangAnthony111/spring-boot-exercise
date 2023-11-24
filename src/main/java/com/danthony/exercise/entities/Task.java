// Entity, part of Spring JPA, represents a record in database table

package com.danthony.exercise.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private int taskId;

//    @ManyToOne(targetEntity = Person.class)
    private int assignee_id;

    private String title;
    private String status;

    @Temporal(TemporalType.DATE)
    private Date due_date;

    // Constructors
    public Task() {
    }

    public Task(String title, int assignee_id, String status, Date due_date) {
        this.title = title;
        this.assignee_id = assignee_id;
        this.status = status;
        this.due_date = due_date;
    }

    // Getter for taskId
    public int getTaskId() {
        return taskId;
    }

    // Getters and Setters for others
    public int getAssignee_id() {
        return assignee_id;
    }

    public void setAssignee_id(int assignee_id) {
        this.assignee_id = assignee_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

}