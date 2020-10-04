package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.school.entity.Student;
import com.example.school.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return studentService.save(student).orElseThrow(() -> new RuntimeException(" Already Exist"));
	}

	@GetMapping("/findAll")
	public List<Student> findAll() {
		return studentService.findAll();
	}

	@GetMapping("/findById/{studentId}")
	public Student findById(@PathVariable("studentId") long studentId) {
		return studentService.findById(studentId)
				.orElseThrow(() -> new RuntimeException(" Student Id :" + studentId + " Not found"));
	}

	@DeleteMapping("/deleteStudent/{studentId}")
	public String deleteById(@PathVariable("studentId") long studentId) {
		return studentService.findById(studentId).map(p -> {
			studentService.deleteById(studentId);
			return "Student Delete";
		}).orElseThrow(() -> new RuntimeException(" Student Id :" + studentId + " Not found"));
	}

	@PutMapping("/updateStudent/{studentId}")
	public String updateStudent(@PathVariable("studentId") long studentId, @RequestBody Student student) {
		return studentService.findById(studentId).map(p -> {
			p.setName(student.getName());
			p.setMobile(student.getMobile());
			p.setEmail(student.getEmail());
			p.setStudentClass(student.getStudentClass());
			p.setRollNumber(student.getRollNumber());
			studentService.save(p);
			return "Student Details Update";
		}).orElseThrow(() -> new RuntimeException("Student Id : " + studentId + " Not found"));
	}
}
