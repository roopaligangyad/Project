package com.cg.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Message;
import com.cg.exception.InvalidMessageException;
import com.cg.repositories.MessageRepository;

@Service
public class MessageServiceImp implements MessageService {
	 // autowiring repository interface
	@Autowired
	transient private MessageRepository messageRepo;

	@Override
	public Message addMessage(LocalDate messageDate, String messageDescription) throws InvalidMessageException {

		Message message = new Message();
		message.setMessageDate(messageDate);
		message.setMessageDescription(messageDescription);

		return messageRepo.save(message);
	}

	@Override
	public List<Message> viewAllMessages() throws InvalidMessageException {

		if (messageRepo.findAll().size() > 0) {

			return messageRepo.findAll();
		} else {

			throw new InvalidMessageException("No messages found!");
		}
	}

	@Override
	public Message viewMessage(final int messageId) throws InvalidMessageException {

		if (messageRepo.existsById(messageId)) {

			return messageRepo.getOne(messageId);
		} else {

			throw new InvalidMessageException("No such message found with id : " + messageId);
		}
	}

}
