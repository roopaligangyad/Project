package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Message;
import com.cg.exception.InvalidInputException;
import com.cg.exception.InvalidMessageException;
import com.cg.services.MessageService;



@RestController
@RequestMapping("/edu/message")
public class MessageController {

	@Autowired
	transient private MessageService messageService;

	@PostMapping("/add-message")
	public Message addMessage(@RequestParam("messageDate") final String date,
			@RequestParam("messageDescription") final String description) throws InvalidMessageException {

		if (date.isEmpty()) {

			throw new InvalidInputException("Date cannot be null");
		}
		if (!(date.matches("^\\d{4}-\\d{2}-\\d{2}$"))) {

			throw new InvalidInputException("Date is invalid");
		}
		if (description.isEmpty()) {

			throw new InvalidInputException("Description cannot be empty ");
		} else {

			return messageService.addMessage(LocalDate.parse(date), description);
		}

	}

	@GetMapping("/view-all-messages")
	public List<Message> viewAllMessages() throws InvalidMessageException {
		
		
		return messageService.viewAllMessages();
	}

	@GetMapping("/view-message")
	public Message viewMessage(@RequestParam("messageId") final int messageId) throws InvalidMessageException {
		
		
		if (messageId < 0) {
		
			throw new InvalidInputException("Message id cannot be negative :" + messageId);
		}
		if (messageId == 0) {
			
			throw new InvalidInputException("Message id cannot be zero :" + messageId);
		}
		if (messageId > 9999) {
			
			throw new InvalidInputException("Message id cannot be greater than 9999 :" + messageId);
		} else {
			
			return messageService.viewMessage(messageId);
		}
	}

}
