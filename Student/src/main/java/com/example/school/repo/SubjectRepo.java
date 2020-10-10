package com.example.school.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.school.entity.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {

	@Query(value = "Select * from subject sub Inner join  student st on st.student_id = sub.student_id where st.roll_number=?1 or st.mobile=?1", nativeQuery = true)
	Optional<Subject> findByRollNo(String rollNo);

}
