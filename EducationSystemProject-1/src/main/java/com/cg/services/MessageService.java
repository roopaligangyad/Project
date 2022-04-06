package com.cg.services;

import java.time.LocalDate;
import java.util.List;

import com.cg.entities.Message;






public interface MessageService {

	 Message addMessage(LocalDate localDate, String messageDescription);
	
	 Message  viewMessage(int messageId);
	
	 List<Message> viewAllMessages();
}
