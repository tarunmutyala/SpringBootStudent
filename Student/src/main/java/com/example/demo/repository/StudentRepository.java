package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value="SELECT * FROM student WHERE collid=:collid ORDER BY name ASC", nativeQuery = true)
	List<Student> getByIdAscName(@Param("collid")int collid);
	
	@Query(value="SELECT * FROM student WHERE collid=:collid ORDER BY age DESC", nativeQuery = true)
	List<Student> getByDeptByDescAge(@Param("collid")int collid);
}
