package com.cg.services;

import java.util.List;

import com.cg.entities.Trainer;
import com.cg.exception.ListEmptyException;
import com.cg.exception.TrainerNotFoundException;



public interface TrainerService {
	
	
	Trainer addTrainer(Trainer trainer);

	void deleteTrainer(int trainerId) throws TrainerNotFoundException;

	Trainer viewTrainer(int trainerId) throws TrainerNotFoundException;

	List<Trainer> viewAllTrainers() throws ListEmptyException;

	

	
}
