package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.TestAssign;
import com.cg.exception.EmptyInputException;

import com.cg.exception.StudentException;

import com.cg.exception.TestException;
import com.cg.services.TestAssignService;

@RestController
@RequestMapping("/api/asign")
public class TestAssignController {

	@Autowired
	private TestAssignService assignService;

	@PostMapping("/addTestforstudent")
	public ResponseEntity<TestAssign> addTestAssign(@RequestBody TestAssign test) throws EmptyInputException {

		TestAssign addtest = assignService.addTestAssign(test);
		return new ResponseEntity<TestAssign>(addtest, HttpStatus.OK);
	}

	@GetMapping(value = "/viewStudentProgress", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<TestAssign>> getStudentProgress(int studentId) throws StudentException {
		List<TestAssign> slist = assignService.getStudentProgress(studentId);
		if (slist.isEmpty()) {
			return new ResponseEntity("Sorry! Student not available!", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<TestAssign>>(slist, HttpStatus.OK);

	}

	@GetMapping("/get-test-ById")
	public int getStudentMark(@RequestParam("id") int studentId, int testId) throws TestException {
		int getMark = assignService.getStudentMark(studentId, testId);
		return getMark;
	}
}
