package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.College;
import com.example.demo.service.CollegeService;
import com.example.demo.vo.RequestTemplate;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	private CollegeService collegeservice;
	
	@PostMapping("/addCollege")
	public College add(@RequestBody College college)
	{
		return collegeservice.add(college);
	}
	
	@GetMapping("/getCollege")
	public List<College> getAllDetails()
	{
		return collegeservice.getAllDetails();
	}
	
	@GetMapping("/{id}")
	public College searchById(@PathVariable int id)
	{
		return collegeservice.searchById(id);
	}
	
	@GetMapping("/ascName")
	public List<RequestTemplate> ascName()
	{
		return collegeservice.ascName();
	}
	
	@GetMapping("/studescage/{collid}")
	public RequestTemplate descAge(@PathVariable int collid)
	{
		return collegeservice.descAge(collid);
	}
}
