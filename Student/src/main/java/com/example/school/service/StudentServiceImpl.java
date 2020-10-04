package com.example.school.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.school.entity.Student;
import com.example.school.repo.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Optional<Student> save(Student student) {
		Optional<Student> optional = Optional.empty();
		if(!findByRollNo(student.getRollNumber())) {
			optional = 	Optional.of(studentRepo.save(new Student(student.getName(),
                      student.getEmail(),
                      student.getMobile(),
                      student.getRollNumber(),
                      student.getStudentClass()
					)));
		}
	return optional;	
	}

	@Override
	public void deleteById(long id) {
		studentRepo.deleteById(id);
	}

	@Override
	public Optional<Student> findById(long id) {
		return studentRepo.findById(id);
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public boolean findByRollNo(String rollno) {
		return studentRepo.findByRollNo(rollno).isPresent();
	}

	
	
}
