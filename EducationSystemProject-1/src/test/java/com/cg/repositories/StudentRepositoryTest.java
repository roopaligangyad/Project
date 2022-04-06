package com.cg.repositories;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.entities.Course;
import com.cg.entities.Student;
import com.cg.repositories.CourseRepository;
import com.cg.repositories.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void setupTest() {
	}

	@Test
	public void testRequestRegistration()
	{
		Student student = new Student();

		student.setFirstName("Aniketk");
		student.setMiddleName("keshavk");
		student.setLastName("karmakark");
		student.setEmailId("aniketk@gmail.com");
		student.setUserName("Aniket");
		student.setContactNumber("8983612958");
		student.setPassword("Aniket$123");
		

		studentRepository.save(student);
		assertNotNull(student);

	}

	@Test
	public void testGetAllStudentsRegistrationRequest() {

		List<Student> student = studentRepository.findAll();
		assertNotNull(student);

	}

	@Test
	public void testGetStudentByIdForValidatingRegistration()
	{
		Student student = new Student();
		
		student.setFirstName("Aniketk");
		student.setMiddleName("keshavk");
		student.setLastName("karmakark");
		student.setEmailId("aniketk@gmail.com");
		student.setUserName("Aniket");
		student.setContactNumber("8983612958");
		student.setPassword("Aniket$123");
	

		studentRepository.save(student);
		Student student2 = studentRepository.getOne(7);
		

		studentRepository.save(student2);
		

	}

	

	@Test
	public void testViewAllStudentDetails()
	{
		List<Student> sList = studentRepository.findAll();
		assertNotNull("All Student details", sList);
		
	}

	@Test
	public void testViewStudentById()
	{
		Student studentObj = studentRepository.getOne(8);
		assertEquals("ani", studentObj.getUserName());
		
	}

	@Test
	public void testUpdateStudentDetails()
	{
		Student st  = new Student();
		st.setFirstName("Vinay");
		st.setMiddleName("Kumar");
		st.setMiddleName("Prajapati");
		st.setEmailId("virusking@gmail.com");
		st.setContactNumber("7325488745");

		Student student = new Student();
		student.setFirstName(st.getFirstName());
		student.setMiddleName(st.getMiddleName());
		student.setLastName(st.getMiddleName());
		student.setEmailId(st.getEmailId());
		student.setContactNumber(st.getContactNumber());
		
		
		Student updateStudentObj = studentRepository.save(student);
		assertEquals(st.getFirstName(), updateStudentObj.getFirstName());
		
	}

	@Test
	public void testViewCourseForStudent()
	{
		Student student = studentRepository.getOne(1);
		List<Course> listOfCourses = (List<Course>) student.getCourses();
		
		assertEquals(5, listOfCourses.size());

		assertEquals("Java", listOfCourses.get(1).getCourseName().toString());
		
	}

	

	@Test
	public void findByCourseName()
	{
		Course course = courseRepository.findByCourseName();
		assertEquals("Java", course.getCourseName());

	}

	@Test
	public void findByUserName()
	{
		Student student = studentRepository.findByUserNameAndPassword(null, null);
		assertNotNull(student);
		
	}


	@Test
	public void findByUserNameAndPassword()
	{
		Student student = studentRepository.findByUserNameAndPassword("aniket", "Aniket$123");
		assertNotNull(student);
		
	}

	

}
