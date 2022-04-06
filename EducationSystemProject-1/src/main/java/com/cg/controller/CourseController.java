package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



import com.cg.entities.Course;
import com.cg.exception.AlreadyExistsException;
import com.cg.exception.ErrorMessages;
import com.cg.exception.InvalidCourseException;
import com.cg.exception.ListEmptyException;
import com.cg.exception.TestNotFoundException;
import com.cg.services.CourseService;



@RestController
@RequestMapping("/edu/course")
public class CourseController {

@Autowired
private CourseService service;



@PostMapping("/add-course")
public ResponseEntity<Course> addCourse(@RequestBody Course course) throws InvalidCourseException {
Course c = service.addCourse(course);
return new ResponseEntity<Course>(c, HttpStatus.OK);



}



@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(InvalidCourseException.class)
public ErrorMessages exceptionHandler(InvalidCourseException invalidEx) {
return new ErrorMessages("400", invalidEx.str);
}



@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(NotFoundException.class)
public ErrorMessages exceptionHandler(NotFoundException notFoundEx) {
return new ErrorMessages("404", notFoundEx.getMessage());
}



@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(ListEmptyException.class)
public ErrorMessages exceptionHandler(ListEmptyException listEmptyEx) {
return new ErrorMessages("404", listEmptyEx.message);
}



@ResponseStatus(HttpStatus.BAD_REQUEST)
@ExceptionHandler(AlreadyExistsException.class)
public ErrorMessages exceptionHandler(AlreadyExistsException alreadyExistEx) {
return new ErrorMessages("400", alreadyExistEx.message);
}



@ResponseStatus(HttpStatus.NOT_FOUND)
@ExceptionHandler(TestNotFoundException.class)
public ErrorMessages exceptionHandler(TestNotFoundException testNotFoundEx) {
return new ErrorMessages("404", testNotFoundEx.message);
}



@GetMapping("/view-course/{courseId}")
public ResponseEntity<Course> viewCourse(@PathVariable("courseId") int courseId) throws NotFoundException {
Course c = service.viewCourse(courseId);
return new ResponseEntity<Course>(c, HttpStatus.OK);



}



@DeleteMapping("/delete-course/{courseId}")
public void deleteCourse(@PathVariable("courseId") int courseId) throws NotFoundException, ListEmptyException {



service.deleteCourse(courseId);

}



@GetMapping("/view-all-courses")
public List<Course> viewAllCourses() throws ListEmptyException {



List<Course> courseList = service.viewAllCourses();



return courseList;
}



}