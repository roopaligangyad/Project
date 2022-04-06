package com.cg.services;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.entities.Course;
import com.cg.entities.Payment;
import com.cg.exception.ListEmptyException;
import com.cg.exception.NotFoundException;
import com.cg.repositories.CourseRepository;
import com.cg.repositories.PaymentRepository;

import com.cg.repositories.StudentRepository;
import com.cg.repositories.TrainerRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CourseServiceTest {
	
	@InjectMocks
	private CourseServiceimpl courseService;
	
	@MockBean
	private CourseRepository courseRepo;
	
	@MockBean 
	private StudentRepository studentRepo;
	
	@MockBean
	private TrainerRepository trainerRepo;
	
	@MockBean
	private PaymentRepository paymentRepo;
	
	
	
	@Test
	public void testAddCourse()
	{
		Course course=new Course();
		
		course.setCourseId(0);
		course.setCourseName("JavaEE");
		course.setHours(12);
		
		Mockito.when(courseRepo.save(course)).thenReturn(course);
		assertThat(courseService.addCourse(course)).isEqualTo(course);
	}
	
	@Test
	public void testViewAllCourses() throws  ListEmptyException {
		Course c1=new Course();
		c1.setCourseName("C");
		c1.setHours(5);
		
		Course c2=new Course();
		c2.setCourseName("SQL");
		c2.setHours(6);
		
		List<Course> courses=new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		
		Mockito.when(courseRepo.findAll()).thenReturn(courses);
		assertThat(courseService.viewAllCourses()).isEqualTo(courses);
		}

	@Test
	public void testViewCourse() throws NotFoundException {
		Course course=new Course();
		course.setCourseId(1);
		course.setCourseName("Python");
		course.setHours(4);
		
		Mockito.when(courseRepo.getOne(1)).thenReturn(course);
		assertThat(courseRepo.getOne(1)).isEqualTo(course);
		
	}
	
	@Test
	public void testDeleteCourse() {
		Course course=new Course();
		course.setCourseId(1);
		course.setCourseName("DBMS");
		course.setHours(5);
		
		Mockito.when(courseRepo.getOne(1)).thenReturn(course);
		Mockito.when(courseRepo.existsById(course.getCourseId())).thenReturn(false);
		assertFalse(courseRepo.existsById(course.getCourseId()));
	}
	
	
	//@Test
	//public void testUpdateCourseForPayment() throws  NotFoundException, org.springframework.data.crossstore.ChangeSetPersister.NotFoundException {
       // Course course=new Course();
		
       // course.setCourseId(1);
		//course.setCourseName("DBMS");
		//course.setHours(5);
		
		//Payment payment=new Payment();
		//payment.setTransactionId(2);
		
		//payment.setAmount(12000);
		
		
		
		//Mockito.when(courseRepo.getOne(1)).thenReturn(course);
		//assertThat(courseService.updateCourseForTest(course.getCourseId(), payment.getTransactionId())).isEqualTo(course);
		
	//}
	
	
	
	
	
}
