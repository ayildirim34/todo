package com.ayil.todo1.Service;

import java.util.List;

import com.ayil.todo1.model.Task;

public interface ITaskService {

	List<Task> getAllTask();

	Task getTask(Long id);

	void deleteTask(Long id);

	Task createTask(Task task);

	Task updateTask(Long id, Task taskDetails);

}
