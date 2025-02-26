package com.ayil.todo1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayil.todo1.model.Task;
import com.ayil.todo1.repository.ITaskRepository;

@Service
public class TaskService implements ITaskService {
	
	@Autowired
	private ITaskRepository taskRepository;
	
	@Override
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}
	
	@Override
	public Task getTask(Long id) {
		return taskRepository.findById(id).orElse(null);
	}
	
	
	@Override
	public void deleteTask(Long id) {
		 taskRepository.deleteById(id);
	}
	
	@Override
	public Task createTask (Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public Task updateTask (Long id, Task taskDetails) {
		Task task = taskRepository.findById(id).orElse(null);
		 if (task == null) {
		        throw new RuntimeException("Task not found with id: " + id);
		    }
		    task.setTitle(taskDetails.getTitle());
		    task.setDescription(taskDetails.getDescription());
		    task.setCompleted(taskDetails.isCompleted());
		    return taskRepository.save(task);
	}
	
	

}
