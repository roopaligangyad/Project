package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Test;
import com.cg.exception.EmptyInputException;
import com.cg.exception.ErrorResponse;
import com.cg.exception.TestException;
import com.cg.services.TestService;





@RestController
@RequestMapping("/api/edu")
public class TestController {
	
	

	@Autowired
	transient private TestService testService;

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(TestException.class)
	public ErrorResponse handlingException( TestException testEx) {
		return new ErrorResponse("Test Not Found", "404");
	}

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmptyInputException.class)
	public ErrorResponse handlingEmptyException(EmptyInputException emptyInputEx) {
		return new ErrorResponse("Input provided are empty!", "400");
	}

	@PostMapping("/addTest")
	public ResponseEntity<Test> addTest(@RequestBody  Test test) throws EmptyInputException {
	
	 Test addtest = testService.addTest(test);
		return new ResponseEntity<Test>(addtest, HttpStatus.OK);
	}

	
	@GetMapping("/get-test-ById")
	public Test getTest(@RequestParam("id")  int testId) throws TestException {
		 Test getById = testService.getTestById(testId);
		
		return getById;
	}

	@GetMapping("/getlist")
	public List<Test> getTestList() throws TestException {
	 List<Test> gettestlist = testService.getAllList();
		if (gettestlist == null) {
			
			throw new TestException("Test Not Found");
		}
		
		return gettestlist;
	}

	@DeleteMapping("/remove")
	public ResponseEntity<Test> deleteTest(@RequestParam("id")  int testId) throws TestException {
   Test  rmtst = testService.deleteTest(testId);
		
		return new ResponseEntity<Test>(rmtst, HttpStatus.OK);
	}

	
}
