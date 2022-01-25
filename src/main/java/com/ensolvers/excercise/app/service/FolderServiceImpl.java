package com.ensolvers.excercise.app.service;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.ensolvers.excercise.app.entity.Folder;
import com.ensolvers.excercise.app.repository.FolderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;


@Service
public class FolderServiceImpl implements FolderService {

	@Autowired
	private FolderRepository folderRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Folder> findAll() {
		return folderRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Folder> findAll(Pageable pageable) {
		return folderRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Folder> findById(Long id) {
		return folderRepository.findById(id);
	}

	@Override
	@Transactional
	public Folder save(Folder folder) {
		return folderRepository.save(folder);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		folderRepository.deleteById(id);
	}



}
