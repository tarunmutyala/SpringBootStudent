package com.example.demo.vo;

public class College {

	private int id;
	private String name;
	private int totalStudents;
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
	public int getTotalStudents() {
		return totalStudents;
	}
	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", totalStudents=" + totalStudents + "]";
	}
	public College(int id, String name, int totalStudents) {
		super();
		this.id = id;
		this.name = name;
		this.totalStudents = totalStudents;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
