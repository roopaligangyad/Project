package com.cg.controller;

import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Trainer;
import com.cg.exception.AlreadyExistsException;
import com.cg.exception.ErrorMessages;
import com.cg.exception.InvalidTrainerException;
import com.cg.exception.ListEmptyException;
import com.cg.exception.TrainerNotFoundException;
import com.cg.services.TrainerService;



@RestController

@RequestMapping("/api/edu/trainer")
public class TrainerController {

	
	@Autowired
	private TrainerService service;

	@PostMapping("/add-trainer")
	public Trainer addTrainer(@RequestBody Trainer trainer) throws InvalidTrainerException {
		
		 String namePattern = "^[a-zA-Z]+$";
		if (trainer.getFirstName() == "" || trainer.getLastName() == "") {
			
			throw new InvalidTrainerException("First nameand last name cannot be Empty!");
		} else if (!Pattern.matches(namePattern, trainer.getFirstName())
				|| !Pattern.matches(namePattern, trainer.getLastName())) {
		
			throw new InvalidTrainerException("First name and last name must contain alphabets only!");
		} else {
		
			Trainer addedTrainer = service.addTrainer(trainer);
			
			return addedTrainer;
		}
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidTrainerException.class)
	public ErrorMessages exceptionHandler( InvalidTrainerException invalidTrainerEx) {
		return new ErrorMessages("400", invalidTrainerEx.message);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TrainerNotFoundException.class)
	public ErrorMessages exceptionHandler( TrainerNotFoundException trainerNotFoundEx) {
		return new ErrorMessages("404", trainerNotFoundEx.message);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ListEmptyException.class)
	public ErrorMessages exceptionHandler( ListEmptyException listEmptyEx) {
		return new ErrorMessages("404", listEmptyEx.message);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AlreadyExistsException.class)
	public ErrorMessages exceptionHandler( AlreadyExistsException alreadyExistEx) {
		return new ErrorMessages("400", alreadyExistEx.message);
	}

	@DeleteMapping("/delete-all-trainers")
	public List<Trainer> deleteAllTrainers() throws ListEmptyException {
		
		
	 List<Trainer> trainerList = service.viewAllTrainers();
		
		return trainerList;
	}

	@DeleteMapping("/delete-trainer/{trainerId}")
	public List<Trainer> deleteTrainer(@PathVariable("trainerId")  int trainerId)
			throws TrainerNotFoundException, ListEmptyException {
		
		service.deleteTrainer(trainerId);
		
		return viewAllTrainers();
	}

	@GetMapping("/view-trainer/{trainerId}")
	public Trainer viewTrainer(@PathVariable("trainerId") int trainerId) throws TrainerNotFoundException {
		
 Trainer trainer = service.viewTrainer(trainerId);
		
		
		return trainer;
	}

	@GetMapping("/view-all-trainers")
	public List<Trainer> viewAllTrainers() throws ListEmptyException {
		
	 List<Trainer> trainerList = service.viewAllTrainers();
		
		return trainerList;
	}

}
