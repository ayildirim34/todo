package com.ayil.todo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayil.todo1.Service.ITaskService;
import com.ayil.todo1.model.Task;

@RestController
@RequestMapping("/api/task")

public class TaskController {
	
	@Autowired
	private ITaskService taskService;
	
	@GetMapping
	public ResponseEntity<List<Task>> getAllTask() {
		return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable("id") Long id, @RequestBody Task taskDetails) {
	    Task updatedTask = taskService.updateTask(id, taskDetails);
	    return new ResponseEntity<>(updatedTask, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
		taskService.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
