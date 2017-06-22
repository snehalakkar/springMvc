package com.bridgeit.restControllerDemo.model;

public class Student {
	
	private int id;

	private String name;

	private String hobby;

	public Student(int id, String name, String hobby) {
		super();
		this.id = id;
		this.name = name;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
