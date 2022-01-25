package com.ensolvers.excercise.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "folders")
public class Folder implements Serializable {

	private static final long serialVersionUID = 8231696825590912723L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "folder_id")
	private Long folderId;
	
	@Column(length = 100, nullable = false)
	private String description;

	@ManyToOne(optional = false,fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User userId;
	
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "task_id")
//    private List<Task> taskList;
	
	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

//	public List<Task> getTaskList() {
//		return taskList;
//	}
//
//	public void setTaskList(List<Task> taskList) {
//		this.taskList = taskList;
//	}


}
