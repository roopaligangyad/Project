package com.cg.services;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Test;
import com.cg.exception.EmptyInputException;
import com.cg.exception.TestException;
import com.cg.repositories.TestRepository;


@Service
public class TestServiceImpl implements TestService {

	@Autowired
	transient private TestRepository testRepo;

	public Test addTest(Test test) throws EmptyInputException {

		return test;

	}

	public Test getTestById(int id) throws TestException {

		Test test = testRepo.findById(id).orElse(null);
		if (test == null) {

			throw new TestException("Test cannot be found!");

		} else {

			return test;
		}
	}

	public List<Test> getAllList() {

		final List<Test> testList = testRepo.findAll();

		return testList;
	}

	public Test deleteTest(final int id) throws TestException {

		Test test = testRepo.findById(id).orElse(null);
		if (test == null) {

			throw new TestException("Test cannot be found!");
		} else {

			test = testRepo.getOne(id);
			testRepo.delete(test);

			return test;
		}
	}

}
