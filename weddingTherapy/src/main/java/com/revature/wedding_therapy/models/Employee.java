package com.revature.wedding_therapy.models;

import java.util.Random;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee{

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	
	public Employee() {
		super();
		this.id = 0;
		this.username = null;
		this.email = null;
		this.password = null;
	}
	
	public Employee(int id, String username, String email, String password) {
		super();
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
	
	@Override
	public String toString() {
		return"ID) "+Integer.toString(id)+
				"\nusername) "+username+"\nemail) "+email+"\npassword) "+password+"\n";
	}

}
