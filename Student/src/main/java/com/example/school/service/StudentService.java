package com.example.school.service;

import java.util.Optional;
import java.util.*;
import com.example.school.entity.*;

public interface StudentService {

	Optional<Student> save(Student student);

	void deleteById(long id);

	Optional<Student> findById(long id);

	List<Student> findAll();
	
	boolean findByRollNo(String rollno);
}
