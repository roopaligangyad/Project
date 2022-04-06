package com.cg.services;

import java.util.List;

import com.cg.entities.Feedback;
import com.cg.exception.InvalidFeedbackException;






public interface FeedbackService {

	Feedback addFeedback(String sname, String feedback);

	List<Feedback> getAllFeedback() throws InvalidFeedbackException;

	//String viewReply(int replyId);

	

}
