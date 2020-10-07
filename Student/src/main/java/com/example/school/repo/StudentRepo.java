package com.example.school.repo;

import java.util.*;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.school.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query(value = "Select * from student s where s.roll_Number=?", nativeQuery = true)
	Optional<Student> findByRollNo(String rollNumber);

	@Query(value = "Select st.name,st.email,st.roll_number,st.student_class,sc.english,sc.hindi,sc.maths,sc.physics,sc.chemistry from student st Inner join subject sc on sc.roll_number=st.roll_number where st.roll_Number=? or st.name=?", nativeQuery = true)
	List<Student> findByValue(String rollNumber);

}
