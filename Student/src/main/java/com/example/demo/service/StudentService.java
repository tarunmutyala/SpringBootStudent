package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.vo.College;
import com.example.demo.vo.ResponseTemplate;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepo;
	
	@Autowired
	private RestTemplate newRestTemplate;
	
	public Student add(Student student) {
		return studentrepo.save(student);
	}
	public List<Student> getAllDetail(){
		return studentrepo.findAll();
	}
	public Student searchById(int id) {
		return studentrepo.findById(id).get();
	}
	
	public ResponseTemplate empWithDept(int stdid) {
		ResponseTemplate responseTemp = new ResponseTemplate();
		Student student = studentrepo.findById(stdid).get();
		int collid = student.getCollid();
		College college = newRestTemplate.getForObject("http://College-Service/college/"+collid, College.class);
		responseTemp.setCollege(college);
		responseTemp.setStudent(student);
		return responseTemp;
	}


	public Student assignDepartment(int stdid, int deptId) {
		Student student = studentrepo.findById(stdid).get();
		College college = newRestTemplate
				.getForObject("http://College-Service/college/"+deptId, College.class);
		if(student==null || college==null)
		{
			return null;
		}
		student.setCollid(deptId);
		studentrepo.save(student);
		return student;
	}

	public List<Student> getByIdAscName(int collid) {
		return studentrepo.getByIdAscName(collid);
	}

	public List<Student> getByDeptByDescAge(int collid) {
		return studentrepo.getByDeptByDescAge(collid);
	}
}
