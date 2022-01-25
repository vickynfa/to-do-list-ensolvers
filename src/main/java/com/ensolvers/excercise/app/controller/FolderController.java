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

import com.ensolvers.excercise.app.entity.Folder;
import com.ensolvers.excercise.app.service.FolderService;

@RestController
@RequestMapping("/api/folders")
public class FolderController {

	@Autowired
	private FolderService folderService;

	// Create
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Folder folder) {
		return ResponseEntity.status(HttpStatus.CREATED).body(folderService.save(folder));
	}

	// Read a folder
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long folderId) {
		Optional<Folder> oFolder = folderService.findById(folderId);
		if (!oFolder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oFolder);
	}

	// Update a folder
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Folder folderDetails, @PathVariable(value = "id") Long folderId) {
		Optional<Folder> oFolder = folderService.findById(folderId);

		if (!oFolder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oFolder.get().setDescription(folderDetails.getDescription());
		oFolder.get().setFolderId(folderDetails.getFolderId());

		return ResponseEntity.status(HttpStatus.CREATED).body(folderService.save(oFolder.get()));
	}

	// Delete a folder

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long folderId) {
		Optional<Folder> oFolder = folderService.findById(folderId);

		if (!oFolder.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		folderService.deleteById(folderId);

		return ResponseEntity.ok().build();
	}

	// Read a folder
	@GetMapping
	public List<Folder> readAll() {
		List<Folder> folders = StreamSupport.stream(folderService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return folders;
	}

}
