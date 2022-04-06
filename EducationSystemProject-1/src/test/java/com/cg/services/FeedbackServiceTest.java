package com.cg.services;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.entities.Feedback;
import com.cg.exception.InvalidFeedbackException;
import com.cg.repositories.FeedbackRepository;



@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
//@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class FeedbackServiceTest {
	
	@InjectMocks
	private FeedbackService feedbackService;
	
	@MockBean 
	private FeedbackRepository feedbackRepo;
	
	@Test
	public void testAddFeedback() {
		Feedback feedback=new Feedback();
		feedback.setFeedback("hi");
		feedback.getFeedback();

		
		Mockito.when(feedbackRepo.save(feedback)).thenReturn(feedback);
		assertThat(feedback).isEqualTo(feedback);
	}
	
	@Test
	public void testViewAllFeedback() throws InvalidFeedbackException {
		Feedback feedback1=new Feedback();
		feedback1.setFeedback("hi");
		
		Feedback feedback2=new Feedback();
		feedback2.setFeedback("hi");
		
		List<Feedback> feedbackList=new ArrayList<>();
		feedbackList.add(feedback1);
		feedbackList.add(feedback2);
		
		Mockito.when(feedbackRepo.findAll()).thenReturn(feedbackList);
		assertThat(feedbackService.getAllFeedback()).isEqualTo(feedbackList);
	}
	
	
}
