package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Feedback;
import com.cg.exception.ErrorDetails;
import com.cg.exception.InvalidFeedbackException;
import com.cg.services.FeedbackServiceImpl;



@RestController
@RequestMapping("/api/edu/feedback")
public class FeedbackController {

	private static  Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

	@Autowired
	transient private FeedbackServiceImpl service;

	@GetMapping("/view-all-feedback")
	public List<Feedback> getAllFeedback() throws InvalidFeedbackException {

		final List<Feedback> feedbackList = service.getAllFeedback();

		return feedbackList;
	}

	@PostMapping("/add-feedback")
	public Feedback addFeedback(@RequestParam("sname") final String sname,
			@RequestParam("feedback") final String feedback) throws InvalidFeedbackException {
		LOGGER.info("for adding feedback-START");
		final String pattern = "^[a-zA-Z0-9]*$";
		final String namePattern = "^[a-zA-Z]+$";

		if (sname == "") {
			
			throw new InvalidFeedbackException("name cannot be empty");
		}
		if (!(sname.matches(namePattern))) {
			
			throw new InvalidFeedbackException("sname cannot contain special symbol and numbers");
		}
		if (feedback == "") {
		
			throw new InvalidFeedbackException("feedback cannot be empty");
		}
//		if (!(feedback.matches(pattern))) {
//			LOGGER.error("feedback cannot contain special symbol");
//			throw new InvalidFeedbackException("feedback cannot contain special symbol");
//		} 
		else {
			LOGGER.info("feedback added succesfully..-END");
			return service.addFeedback(sname, feedback);
		}
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidFeedbackException.class)
	public ErrorDetails exceptionHabler(final InvalidFeedbackException ex) {
		return new ErrorDetails("400", ex.message);
	}

	@PatchMapping("/add-reply")
	public Feedback updateFeedbackForReply(@RequestParam("id") final int replyId,
			@RequestParam("reply") final Feedback reply) throws InvalidFeedbackException {
			
		return reply;
	}

	
}
