package com.revature.wedding_therapy.models;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@Column(name="employ_id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	
	public Employee() {
		this.id = 0;
		this.username = null;
		this.email = null;
		this.password = null;
	}
	public Employee(String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public int getId() {
		return id;
	}
	
	public String toString() {
		String answer = 
	}

	
	
	
	
}
