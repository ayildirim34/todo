package com.ayil.todo1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayil.todo1.model.Task;

public interface ITaskRepository extends JpaRepository<Task, Long>{

}
