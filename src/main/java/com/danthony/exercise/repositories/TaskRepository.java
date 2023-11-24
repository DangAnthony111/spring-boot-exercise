// Repository, part of Spring JPA, defines methods for performing CRUD operations on Entities

package com.danthony.exercise.repositories;

import com.danthony.exercise.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE t.taskId = ?1")
    Task findTaskByTaskId(int taskId);


}
