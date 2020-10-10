package com.example.school.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.school.entity.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {

	
	
}
