package com.ensolvers.excercise.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ensolvers.excercise.app.entity.Task;

public interface TaskService {

	public Iterable<Task> findAll();

	public Page<Task> findAll(Pageable pageable);

	public Optional<Task> findById(Long id);

	public Task save(Task user);

	public void deleteById(Long id);

}
