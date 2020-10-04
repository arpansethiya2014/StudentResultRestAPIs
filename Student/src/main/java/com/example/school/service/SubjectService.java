package com.example.school.service;

import java.util.List;
import java.util.Optional;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;

public interface SubjectService {

	Subject save(Subject subject);

	void deleteById(long id);

	Optional<Subject> findById(long id);

	List<Subject> findAll();
	
	Optional<Student> findByRollNo(String rollno);

}
