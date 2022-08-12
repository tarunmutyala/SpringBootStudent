package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.controller.StudentController;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentApplicationTests {

	@Test
	void contextLoads() {
	}

	public static Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentController stucontroller = mock(StudentController.class);

	@MockBean
	private StudentRepository sturepo;
	
	@Autowired
	private StudentService studentservice;
	
	
	
	@Test
	public void add() throws Exception {
		logger.info("save Students test executing");
		Student student = new Student(10,"Venkatesh",23."Male","Science");
		//Student student = new Student(103,"Sai","Male",25,1 );
		when(stucontroller.add(student)).thenReturn(student);
		assertThat(student.getId()).isGreaterThan(0);
		assertEquals(studentservice.add(student),stucontroller.add(student));
	}
	
	@Test
	public void getAllDetail() throws Exception {
		logger.info("Get Students test executing");
		when(stucontroller.getAllDetail()).thenReturn(Stream
				.of(new Student(10,"Venkatesh", 23."Male","Science"), 
				new Student(10,"Venkatesh",23."Male","Science"));
				.collect(Collectors.toList()));
		Assertions.assertThat(studentservice.getAllDetail().isEmpty());
		assertEquals(2, studentservice.getAllDetail().size());
	}
}
