package com.ensolvers.excercise.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ensolvers.excercise.app.entity.Folder;

public interface FolderService {

	public Iterable<Folder> findAll();

	public Page<Folder> findAll(Pageable pageable);

	public Optional<Folder> findById(Long id);

	public Folder save(Folder user);

	public void deleteById(Long id);

}
