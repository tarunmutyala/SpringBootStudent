package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.College;

public class RequestTemplate {

	private College college;
	private List<Student> student= new ArrayList<Student>();
	public RequestTemplate(College college, List<Student> student) {
		super();
		this.college = college;
		this.student = student;
	}
	public RequestTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}

	
}
