package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id 
	private int id;
	private String name;
	private int age;
	private String gender;
	private String stream;
	private int collid;
	
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
	
	public int getCollid() {
		return collid;
	}
	public void setCollid(int collid) {
		this.collid = collid;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, int age, String gender, String stream, int collid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.stream = stream;
		this.collid = collid;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", stream=" + stream
				+ ", collid=" + collid + "]";
	}

	
	

	
}
