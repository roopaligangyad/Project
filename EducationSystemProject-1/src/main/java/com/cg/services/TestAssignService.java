package com.cg.services;

import java.util.List;

import com.cg.entities.Student;
import com.cg.entities.Test;
import com.cg.entities.TestAssign;

public interface TestAssignService {

//	TestAssign assignTest(int studentId, int testId);
//
//	Student getAssignTestByStudentId(int studentId);
//
//	Test getAssignTestByTestId(int testId);

	int getStudentMark(int studentId, int testId);

	List<TestAssign> getStudentProgress(int studentId);

	TestAssign addTestAssign(TestAssign test);

	

}
