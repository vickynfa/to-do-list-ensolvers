package com.ensolvers.excercise.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.excercise.app.entity.Task;
import com.ensolvers.excercise.app.service.TaskService;



@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	// Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Task task) {
		return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(task));
	}

	// Read a task
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long taskId) {
		Optional<Task> oTask = taskService.findById(taskId);
		if (!oTask.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oTask);
	}

	// Update a task
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Task taskDetails, @PathVariable(value = "id") Long taskId) {
		Optional<Task> oTask = taskService.findById(taskId);

		if (!oTask.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oTask.get().setDescription(taskDetails.getDescription());
//		oTask.get().setFolderId(taskDetails.getFolderId());
		oTask.get().setIsCompleted(taskDetails.getIsCompleted());

		return ResponseEntity.status(HttpStatus.CREATED).body(taskService.save(oTask.get()));
	}

	// Delete a task

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long taskId) {
		Optional<Task> oTask = taskService.findById(taskId);

		if (!oTask.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		taskService.deleteById(taskId);

		return ResponseEntity.ok().build();
	}

	// Read a task
	@GetMapping
	public List<Task> readAll() {
		List<Task> tasks = StreamSupport.stream(taskService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return tasks;
	}

}
