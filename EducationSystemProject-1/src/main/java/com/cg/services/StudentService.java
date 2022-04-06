package com.cg.services;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import com.cg.entities.Course;
import com.cg.entities.Student;
import com.cg.exception.AlreadyEnrolledInCourseException;
import com.cg.exception.CourseNotFoundException;
import com.cg.exception.EmailAlreadyExistsException;
import com.cg.exception.PasswordAndConfirmPasswordNotMatchException;
import com.cg.exception.RegistrationRequestNotApprovedException;
import com.cg.exception.StudentNotFoundException;
import com.cg.exception.UserNameExistException;

public interface StudentService {

	

	List<Student> viewAllStudentDetails();

	Student viewStudentById(int id)
			throws EntityNotFoundException, StudentNotFoundException, RegistrationRequestNotApprovedException;

	Student updateStudentDetails(int id, Student student)
			throws EntityNotFoundException, StudentNotFoundException, RegistrationRequestNotApprovedException;

	Set<Course> viewCourseForStudent(int id) throws EntityNotFoundException, StudentNotFoundException,
			RegistrationRequestNotApprovedException, CourseNotFoundException;

	boolean deleteStudentById(int id)  ;
	Student addStudent(Student student)  ;
}
