package com.servlet.dto;

public class StudentDTO {
	int id;
	String name;
	String email;
	
	public StudentDTO(int id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
