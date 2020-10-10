package com.example.school.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.school.entity.Student;
import com.example.school.entity.Subject;
import com.example.school.repo.StudentRepo;
import com.example.school.repo.SubjectRepo;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepo subjectRepo;
	
	@Override
	public Subject save(Subject subject) {
		return subjectRepo.save(subject);
	}

	@Override
	public void deleteById(long id) {
		subjectRepo.deleteById(id);
	}

	@Override
	public Optional<Subject> findById(long id) {
		return subjectRepo.findById(id);
	}

	@Override
	public List<Subject> findAll() {
		return subjectRepo.findAll();
	}

	@Override
	public Optional<Subject> findByRollNo(String rollno) {
		return subjectRepo.findByRollNo(rollno);
	}
	
	

}
