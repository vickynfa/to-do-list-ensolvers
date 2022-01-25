package com.ensolvers.excercise.app.service;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.ensolvers.excercise.app.entity.User;

import org.springframework.data.domain.Page;


public interface UserService {

	public Iterable<User> findAll();

	public Page<User> findAll(Pageable pageable);

	public Optional<User> findById(Long id);

	public User save(User user);
	
	public void deleteById(Long id);
	

}
