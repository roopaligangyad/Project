package com.cg.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Student;
import com.cg.exception.RegistrationRequestNotApprovedException;
import com.cg.exception.StudentException;
import com.cg.exception.StudentNotFoundException;

import com.cg.services.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping("/add/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) throws StudentException {
		Student s1 = studentService.addStudent(student);
		if (s1 == null) {
			return new ResponseEntity("Sorry! Student not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(s1, HttpStatus.OK);

	}

	@GetMapping(value = "/view/student/{studentId}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Student> getStudentforId(@PathVariable("studentId") Integer studentId)
			throws StudentException, EntityNotFoundException, StudentNotFoundException,
			RegistrationRequestNotApprovedException {
		Student s1 = studentService.viewStudentById(studentId);
		if (s1 == null) {
			return new ResponseEntity("Sorry! Student not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Student>(s1, HttpStatus.OK);

	}

	@GetMapping(value = "/viewAll/students", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Student>> getStudentList() throws StudentException {
		List<Student> slist = studentService.viewAllStudentDetails();
		if (slist.isEmpty()) {
			return new ResponseEntity("Sorry! Student not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<Student>>(slist, HttpStatus.OK);

	}

	@PutMapping(value = "/student/edit/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student s)
			throws StudentException, EntityNotFoundException, StudentNotFoundException,
			RegistrationRequestNotApprovedException {
		Student c1 = studentService.updateStudentDetails(studentId, s);
		if (c1 == null) {
			return new ResponseEntity("Sorry! Student not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Student>(c1, HttpStatus.OK);

	}

	@DeleteMapping(value = "/student/del/{studentid}")
	public ResponseEntity<String> deleteStudentById(@PathVariable("studid") Integer sid) {
		boolean s = studentService.deleteStudentById(sid);
		if (s == false) {
			return new ResponseEntity("Sorry!Student not be deleted!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("Student  deleted", HttpStatus.OK);

	}

}
