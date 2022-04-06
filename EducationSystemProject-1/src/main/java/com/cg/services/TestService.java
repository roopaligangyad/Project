package com.cg.services;

import java.util.List;

import com.cg.entities.Test;
import com.cg.exception.EmptyInputException;
import com.cg.exception.TestException;





public interface TestService {
	public Test addTest(final Test test) throws EmptyInputException;
	public Test getTestById(final int id) throws TestException;
	public List<Test> getAllList();
	public Test deleteTest(final int id) throws TestException;
	
	
	
	
}
