package com.example.demo.vo;

import javax.persistence.Id;

public class Student {


	private int id;
	private String name;
	private int age;
	private String gender;
	private String stream;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, int age, String gender, String stream) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.stream = stream;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", stream=" + stream
				+ "]";
	}
	
	
}
