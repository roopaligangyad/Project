package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Student;
import com.cg.entities.Test;
import com.cg.entities.TestAssign;
import com.cg.repositories.TestAssignRepository;

@Service
public class TestAssignServivceImpl implements TestAssignService {

	@Autowired
	private TestAssignRepository testAssignRepository;

	@Override
	public int getStudentMark(int studentId, int testId) {
		// TODO Auto-generated method stub
		return testAssignRepository.getStudentMark(studentId, testId);
	}

	@Override
	public List<TestAssign> getStudentProgress(int studentId) {
		// TODO Auto-generated method stub
		return testAssignRepository.getStudentProgress(studentId);
	}

	@Override
	public TestAssign addTestAssign(TestAssign test) {
		// TODO Auto-generated method stub
		return testAssignRepository.save(test);
	}

}
