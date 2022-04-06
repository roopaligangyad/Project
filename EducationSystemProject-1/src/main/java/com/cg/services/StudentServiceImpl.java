package com.cg.services;


import java.util.List;
import java.util.Set;


import javax.persistence.EntityNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entities.Course;
import com.cg.entities.Student;

import com.cg.exception.CourseNotFoundException;


import com.cg.exception.RegistrationRequestNotApprovedException;
import com.cg.exception.StudentNotFoundException;

import com.cg.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {



	@Autowired
	 private StudentRepository studentRepository;



	

	@Override
	public List<Student> viewAllStudentDetails() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student viewStudentById(int id)
			throws EntityNotFoundException, StudentNotFoundException, RegistrationRequestNotApprovedException {
		
		return studentRepository.getById(id);
	}

	@Transactional
	@Override
	public Student updateStudentDetails(int id, Student student)
			throws EntityNotFoundException, StudentNotFoundException, RegistrationRequestNotApprovedException {
		
		return studentRepository.save(student);
	}

	@Override
	public Set<Course> viewCourseForStudent(int id) throws EntityNotFoundException, StudentNotFoundException,
			RegistrationRequestNotApprovedException, CourseNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public boolean  deleteStudentById(int id) {
		// TODO Auto-generated method stub
		  studentRepository.deleteById(id);
		  return true;
	}
    @Transactional
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}


	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Override
//	public boolean requestRegistration(final Student student)
//			throws EmailAlreadyExistsException, UserNameExistException, PasswordAndConfirmPasswordNotMatchException
//	{
//
//		
//		boolean isRequestMade = false;
//
//		if (studentRepository.findByEmailId(student.getEmailId()) != null)
//		{
//			
//			throw new EmailAlreadyExistsException("Email already taken!! Please use other email");
//		}
//		else if (studentRepository.findByUserName(student.getUserName()) != null)
//		{
//			LOGGER.warn("Username already taken!! Please use other username");
//			throw new UserNameExistException("Username already taken!! Please use other username");
//		}
////		else if (!(student.getPassword().equals(student.getConfirmPassword())))
////		{
////			LOGGER.warn("Password and Confirm password doesn't matched");
////			throw new PasswordAndConfirmPasswordNotMatchException("Password and Confirm password doesn't matched");
////		}
//		else
//		{
//			studentRepository.saveAndFlush(student);
//			isRequestMade = true;
//		}
//		
//		LOGGER.info("End of the requestRegistration method of service layer - END");
//		return isRequestMade;
//
//	}
//
//	
//
//	@Override
//	public List<Student> getAllStudentsRegistrationRequest()
//	{
//		LOGGER.info("Inside the getAllStudentsRegistrationRequest method of service layer - START");
//		final List<Student> getAllRegistrationRequest = studentRepository.findByIsValidateTrue();
//		
//		if(getAllRegistrationRequest.isEmpty())
//		{	
//			LOGGER.info("End of the getAllStudentsRegistrationRequest method of service layer and returning null - END");
//			return null;
//			
//		}
//		else
//		{
//			LOGGER.info("End of the getAllStudentsRegistrationRequest method of service layer - END");
//			return getAllRegistrationRequest;
//			
//		}
//		
//	}
//
//	
//	@Override
//	public boolean getStudentByIdForValidatingRegistration(final int id) throws EntityNotFoundException
//	{
//		LOGGER.info("Inside the getStudentByIdForValidatingRegistration method of service layer - START");
//		final Student studentObj = studentRepository.getOne(id);
//		boolean validated = false;
//
////		if (!(studentObj.isValidate()))
////		{
////			studentObj.setValidate(true);
////			studentObj.setConfirmPassword(studentObj.getPassword());
////			studentRepository.save(studentObj);
////			validated = true;
////			
////		} 
////		else
////		{
////			validated = false;
////			
////		}
//		
//		LOGGER.info("End of the getStudentByIdForValidatingRegistration method of service layer - END ");
//		return validated;
//	}
//
//
//	@Override
//	public Student validateStudentLogin(final String userName,final String password)
//			throws StudentNotFoundException, RegistrationRequestNotApprovedException
//	{
//
//		LOGGER.info("Inside the validateStudentLogin method of the service layer - START");
//		boolean isAuthorized = false;
//		final Student studentObj = studentRepository.findByUserName(userName);
//		//System.out.println(studentObj);
//		
//		if (studentObj != null)
//		{
//			if (!(studentObj.isValidate()))
//			{
//				LOGGER.warn(
//						"You are not allowed to login because you're registration request haven't been approved yet");
//				throw new RegistrationRequestNotApprovedException(
//						"You are not allowed to login because you're registration request haven't been approved yet");
//				
//			}
//			else
//			{
//				final Student student = studentRepository.findByUserNameAndPassword(userName, password);
//				System.out.println(student);
//				if (student != null)
//				{
//					isAuthorized = true;
//				} 
//				else
//				{
//					isAuthorized = false;
//				}
//			}
//		} 
//		else
//		{
//			LOGGER.warn("Student not exists!!");
//			throw new StudentNotFoundException("Student not exists!!");
//			
//		}
//		
//		LOGGER.info("End of the validateStudentLogin method of service layer - END");
////		return studentObj;
//		if(isAuthorized) {
//			return studentObj;
//		}
//		else {
//			return null;
//		}
//	}
//
//
//	@Override
//	public List<Student> viewAllStudentDetails()
//	{
//		LOGGER.info("Inside the viewAllStudentDetails method of the service layer - START");
//		final List<Student> studentList = studentRepository.findByIsValidateTrue();
//		
//		if(studentList != null)
//		{
//			LOGGER.info("End of the viewAllStudentDetails method of the service layer - END");
//			return studentList;
//		}
//		else
//		{
//			LOGGER.info("End of the viewAllStudentDetails method of the service layer and returning null is i.e no student available - END");
//			return null;
//		}
//		
//		
//	}
//
//	
//
//	@Override
//	public Student viewStudentById(final int id)
//			throws EntityNotFoundException, StudentNotFoundException, RegistrationRequestNotApprovedException
//	{
//		LOGGER.info("Inside the viewStudentById method of the service layer - START");
//		final Student studentObj = studentRepository.getOne(id);
//		
//		if (studentObj != null)
//		{
//			if (!(studentObj.isValidate()))
//			{
//				LOGGER.warn("This student details can't be shown because it is not validated yet!!");
//				throw new RegistrationRequestNotApprovedException(
//						"This student details can't be shown because it is not validated yet!!");
//				
//			} else
//			{
//				LOGGER.info("End of the viewStudentById method of the service layer - END");
//				return studentObj;
//				
//			}
//		}
//		else
//		{
//			LOGGER.warn("Student with given id is not available");
//			throw new StudentNotFoundException("Student with given id is not available");
//			
//		}
//	}
//
//	
//
//	@Override
//	public Student updateStudentDetails(final int id,final StudentDTO studentDTO)
//			throws EntityNotFoundException, StudentNotFoundException, RegistrationRequestNotApprovedException
//	{
//		LOGGER.info("Inside the updateStudentDetails method of the service layer - START");
//		final Student student = studentRepository.getOne(id);
//		
//		if (!(student.isValidate()))
//		{
//			LOGGER.warn("This student details can't be shown because it is not validated yet!!");
//			throw new RegistrationRequestNotApprovedException(
//					"This student details can't be shown because it is not validated yet!!");
//			
//		}
//		else
//		{
//			student.setFirstName(studentDTO.getFirstName());
//			student.setMiddleName(studentDTO.getMiddleName());
//			student.setLastName(studentDTO.getLastName());
//			student.setEmailId(studentDTO.getEmailId());
//			student.setContactNumber(studentDTO.getContactNumber());
//			  
//			
//			Student updateStudentObj = studentRepository.save(student);
//			
//			LOGGER.info("End of the updateStudentDetails method of the service layer - END");
//			return updateStudentObj;
//			
//		}
//	}
//
//	@Override
//	public Set<Course> viewCourseForStudent(final int id)
//			throws EntityNotFoundException, StudentNotFoundException, RegistrationRequestNotApprovedException, CourseNotFoundException
//	{
//		LOGGER.info("Inside the viewCourseForStudent method of the service layer - START");
//		final Student student = studentRepository.getOne(id);
//
//		if (!(student.isValidate()))
//		{
//			LOGGER.warn("This student details can't be shown because it is not validated yet!!");
//			throw new RegistrationRequestNotApprovedException(
//					"This student details can't be shown because it is not validated yet!!");
//			
//		}
//		else
//		{
//			if (student.getCourses().isEmpty())
//			{
//				LOGGER.info("End of the viewCourseForStudent method of the service layer adn retuning null i.e no courses enrolled- END");
//				throw new CourseNotFoundException("No courses enrolled by student yet!!");
//				
//			}
//			
//			LOGGER.info("End of the viewCourseForStudent method of the service layer - END");
//			return student.getCourses();
//			
//		}
//	}
//	
//	
//	
//
//	@Override
//	public Student updateStudentForCourse(final int id,final String name) throws EntityNotFoundException, StudentNotFoundException,
//			RegistrationRequestNotApprovedException, CourseNotFoundException, AlreadyEnrolledInCourseException
//	{
//		LOGGER.info("Inside the updateStudentForCourse method of the service layer - START");
//		final Student student = studentRepository.getOne(id);
//
//		if (student != null)
//		{
//			if (!(student.isValidate()))
//			{
//				LOGGER.warn("This student details can't be shown because it is not validated yet!!");
//				throw new RegistrationRequestNotApprovedException(
//						"This student details can't be shown because it is not validated yet!!");
//				
//			}
//			else
//			{
//				final Set<Course> listOfCourses = student.getCourses();
//				final List<String> courseNameList = listOfCourses.stream().map(e -> e.getCourseName())
//						.collect(Collectors.toList());
//				
//				if (courseNameList.contains(name))
//				{
//					LOGGER.warn("Already enrolled in the given course!!");
//					throw new AlreadyEnrolledInCourseException("Already enrolled in the given course!!");
//					
//				}
//				else
//				{
//					final Set<Course> courseList = (Set<Course>) new ArrayList<Course>();
//					final Course course = courseRepository.findByCourseName(name);
//					
//					if (course != null)
//					{
//						courseList.add(course);
//						student.setCourses(courseList);
//						studentRepository.save(student);
//						
//						LOGGER.info("End of the updateStudentForCourse method of the service layer - END");
//						return student;
//						
//					}
//					else
//					{
//						LOGGER.warn("Course with the given name is not available!!");
//						throw new CourseNotFoundException("Course with the given name is not available!!");
//						
//					}
//				}
//
//			}
//		}
//		else
//		{
//			LOGGER.warn("Student with the given ID is not available");
//			throw new StudentNotFoundException("Student with the given ID is not available");
//			
//		}
//	}
//
//
//
//	public Student updateStudentDetails(int studentId, Student studentDTO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//}
