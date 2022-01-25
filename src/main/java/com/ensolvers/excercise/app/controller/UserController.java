package com.ensolvers.excercise.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
import org.springframework.web.bind.annotation.RestController;

import com.ensolvers.excercise.app.entity.User;
import com.ensolvers.excercise.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	// Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}

	// Read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId) {
		Optional<User> oUser = userService.findById(userId);
		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
	}

	// Update an user
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId) {
		Optional<User> oUser = userService.findById(userId);

		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oUser.get().setName(userDetails.getName());
		oUser.get().setSurname(userDetails.getSurname());
		oUser.get().setEmail(userDetails.getEmail());
		oUser.get().setEnabled(userDetails.getEnabled());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(oUser.get()));
	}

	// Delete an user

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
		Optional<User> oUser = userService.findById(userId);

		if (!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(userId);

		return ResponseEntity.ok().build();
	}

	// Read an user
	@GetMapping
	public List<User> readAll() {
		List<User> users = StreamSupport.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}

}
