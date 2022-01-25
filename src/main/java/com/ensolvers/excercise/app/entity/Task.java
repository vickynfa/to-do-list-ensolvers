package com.ensolvers.excercise.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = -7233109802368228234L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long taskId;
	
	@Column(length = 100, nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Boolean isCompleted;
	
//	@ManyToOne(optional = true, fetch = FetchType.EAGER)
//	@JoinColumn(name = "folder_id")
//	private Folder folderId;
//	
//	@ManyToOne(optional = false, fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id")
//	private User userId;
	

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

//	public Folder getFolderId() {
//		return folderId;
//	}
//
//	public void setFolderId(Folder folderId) {
//		this.folderId = folderId;
//	}
//
//	public User getUserId() {
//		return userId;
//	}
//
//	public void setUserId(User userId) {
//		this.userId = userId;
//	}
	




	
	
}
