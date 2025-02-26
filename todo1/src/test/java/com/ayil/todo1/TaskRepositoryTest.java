package com.ayil.todo1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ayil.todo1.model.Task;
import com.ayil.todo1.repository.ITaskRepository;

@DataJpaTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)

public class TaskRepositoryTest {
	
	@Autowired
	private ITaskRepository taskRepository;
	
	@Test
	public void saveTest() {
		Task task = new Task();
		task.setTitle("task");
		task.setDescription("This is a task");
		task.setCompleted(false);
		
		Task savedTask=taskRepository.save(task);
		
		assertThat(savedTask).isNotNull();
		assertThat(savedTask.getId()).isNotNull();
	}
	

}
