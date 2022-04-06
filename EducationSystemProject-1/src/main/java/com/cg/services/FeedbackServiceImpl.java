package com.cg.services;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Feedback;
import com.cg.exception.InvalidFeedbackException;
import com.cg.repositories.FeedbackRepository;






@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	
	
	
	@Autowired
	transient private FeedbackRepository feedbackRepo;

	
	@Override
	public Feedback addFeedback( String sname, String feedback) {
		
	 Feedback feedback1 = new Feedback();
		
		feedback1.setFeedback(feedback);
	 Feedback addFeedback = feedbackRepo.save(feedback1);
		
		return addFeedback;
	}


	
	@Override
	public List<Feedback> getAllFeedback() throws InvalidFeedbackException {
		
	 List<Feedback> feedbackList = feedbackRepo.findAll();
		if (feedbackList.size() > 0) {
		
			return feedbackList;
		} else {
			
			throw new InvalidFeedbackException("No Feedbacks to show");
		}
	}




	
	
}
