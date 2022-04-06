package com.cg.services;

import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.cg.entities.Course;
import com.cg.exception.ListEmptyException;
public interface CourseService {
	
Course addCourse(Course courseName);
void deleteCourse(int courseId) throws NotFoundException;
Course viewCourse(int courseId) throws NotFoundException;
List<Course> viewAllCourses() throws ListEmptyException;

}