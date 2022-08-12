package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.College;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.vo.RequestTemplate;
import com.example.demo.vo.Student;

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegerepo;
	@Autowired
	private RestTemplate newTemplate;
	
	
	public College add(College newCollege) {
		return collegerepo.save(newCollege);
	}
	
	public List<College> getAllDetails(){
		return collegerepo.findAll();
	}
	
	public College update(int id, String name) {
		College college = collegerepo.findById(id).get();
		college.setName(name);
		return collegerepo.save(college);
	}

	public College searchById(int id) {
		if(collegerepo.findById(id)==null)
		{
			return null;
		}
		return collegerepo.findById(id).get();
	}
	public List<RequestTemplate> ascName() {
		List<RequestTemplate> templatelist = new ArrayList<RequestTemplate>();
		List<College> college = this.getAllDetails();
		Iterator<College> it = college.iterator();
		while(it.hasNext())
		{
			College coll = it.next();
			ResponseEntity<Student[]> response =
					newTemplate.getForEntity("http://Student-Service/student/stuascname/"+coll.getId(),
							Student[].class);
			Student[] student = response.getBody();
			List<Student> stu = Arrays.asList(student);
 			RequestTemplate resttemplate = new RequestTemplate();
 			resttemplate.setCollege(coll);
 			resttemplate.setStudent(stu);
 			templatelist.add(resttemplate);
		}
		return templatelist;
	}

	public RequestTemplate descAge(int dept_id) {
		College college  = this.searchById(dept_id);
		
		ResponseEntity<Student[]> response =
				newTemplate.getForEntity("http://Student-Service/student/studescage/"+college.getId(),
						Student[].class);
		Student[] student = response.getBody();
		List<Student> students = Arrays.asList(student);
		RequestTemplate requestTemplate = new RequestTemplate();
		
		requestTemplate.setCollege(college);
		requestTemplate.setStudent(students);
		
		return requestTemplate;
	}
}
