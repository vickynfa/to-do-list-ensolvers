package com.ensolvers.excercise.app.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.ensolvers.excercise.app.entity.Task;
import com.ensolvers.excercise.app.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Task> findAll(Pageable pageable) {
		return taskRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Task> findById(Long id) {
		return taskRepository.findById(id);
	}

	@Override
	@Transactional
	public Task save(Task task) {
		return taskRepository.save(task);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		taskRepository.deleteById(id);
	}


}
