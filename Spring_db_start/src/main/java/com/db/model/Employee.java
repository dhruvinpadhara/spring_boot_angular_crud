package com.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue
	@Column(length=8)
	private int id;
	
	@Column(length=30)
	private String name;
	
	@Column(length=20)
	private String email;

	
	
	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}


	public Employee(int id) {
		super();
		this.id = id;
	}


	public Employee(int id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}


	public Employee() {
		super();
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
