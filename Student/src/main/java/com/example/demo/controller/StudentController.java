package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.example.demo.vo.ResponseTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@PostMapping("/addStudent")
	public Student add(@RequestBody Student student)
	{
		return studentservice.add(student);
	}
	
	@GetMapping("/getStudent")
	public List<Student> getAllDetail(){
		return studentservice.getAllDetail();
	}
	
	@GetMapping("/{stdId}")
	public ResponseTemplate empWithDept(@PathVariable int stdId)
	{
		return studentservice.empWithDept(stdId);
	}
	
	@PutMapping("/{stdId}/{collid}")
	public String updateDepartment(@PathVariable int stdId,@PathVariable int collid, Student student)
	{
		student = studentservice.assignDepartment(stdId,collid);
		if(student!=null)
		{
			return student.toString();
		}
		return "Not Found";
	}
	
	@GetMapping("/stuascname/{collid}")
	public List<Student> getByIdAscName(@PathVariable int collid)
	{
		return studentservice.getByIdAscName(collid);
	}
	
	@GetMapping("/studescage/{collid}")
	public List<Student> getByDeptByDescAge(@PathVariable int collid)
	{
		return studentservice.getByDeptByDescAge(collid);
	}
}
