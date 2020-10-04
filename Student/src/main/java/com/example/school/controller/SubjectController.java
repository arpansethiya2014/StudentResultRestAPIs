package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.school.entity.Subject;
import com.example.school.service.SubjectService;

@RestController
@RequestMapping("/api/subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/save")
	public String saveSubject(@RequestBody Subject subject) {
		return subjectService.findByRollNo(subject.getRollNumber()).map(p ->{
			subjectService.save(subject);
			return "Save Roll Number Marks : " + subject.getRollNumber();
		}).orElseThrow(() -> new RuntimeException(" Roll Number Not Found : " + subject.getRollNumber()));
	}
	
	@DeleteMapping("/delete")
	public String deleteSubject(@PathVariable("subjectId") long id) {
		return subjectService.findById(id).map(p ->{
			subjectService.deleteById(id);
			return "Delete Subject Deials : " + id;
		}).orElseThrow(() -> new RuntimeException(" Subject id : " + id + " Not Found"));
	}
	
	@GetMapping("/findAll")
	public List<Subject> findAll(){
		return subjectService.findAll();
	}
}
