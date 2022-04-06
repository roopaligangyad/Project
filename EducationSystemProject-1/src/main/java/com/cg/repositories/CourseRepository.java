package com.cg.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entities.Course;




@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("Select c from Course c where c.courseName=?1 ")
	public Course findByCourseName();

	
}
