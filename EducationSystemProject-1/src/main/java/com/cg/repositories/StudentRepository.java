package com.cg.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
 @Query("Select s from Student s where s.userName=?1 and s.password=?2")
	public Student findByUserNameAndPassword(String username, String password);

	
	
	
	
}

