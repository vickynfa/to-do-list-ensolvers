package com.ensolvers.excercise.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = -7030423139488278366L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(length = 70, nullable = false)
	private String name;

	@Column(length = 70, nullable = false)
	private String surname;

	@Column(length = 100, nullable = false, unique = true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
//	@OneToMany(mappedBy = "userId")
//	private List<Task> taskList;
//
//	@OneToMany(mappedBy = "userId")
//	private List<Folder> folderList;
	
	private Boolean enabled;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public List<Task> getTaskList() {
//		return taskList;
//	}
//
//	public void setTaskList(List<Task> taskList) {
//		this.taskList = taskList;
//	}
//
//	public List<Folder> getFolderList() {
//		return folderList;
//	}
//
//	public void setFolderList(List<Folder> folderList) {
//		this.folderList = folderList;
//	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
 
	

}
