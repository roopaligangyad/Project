package com.cg.services;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Trainer;
import com.cg.exception.ListEmptyException;
import com.cg.exception.TrainerNotFoundException;
import com.cg.repositories.TrainerRepository;


@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	transient private TrainerRepository trainerRepo;

	@Override
	public Trainer addTrainer(Trainer trainer) {

		trainerRepo.save(trainer);

		return trainer;
	}

	@Override
	public void deleteTrainer(int id) throws TrainerNotFoundException {

		if (trainerRepo.existsById(id)) {
			trainerRepo.deleteById(id);

		} else {

			throw new TrainerNotFoundException("Trainer cannot be deletes as this trainer is not found!");
		}
	}

	@Override
	public Trainer viewTrainer(int trainerId) throws TrainerNotFoundException {

		Trainer trainer = trainerRepo.findById(trainerId).orElse(null);
		if (trainer == null) {

			throw new TrainerNotFoundException("Trainer cannot be found!");
		} else {

			return trainer;
		}

	}

	@Override
	public List<Trainer> viewAllTrainers() throws ListEmptyException {

	 List<Trainer> trainerList = trainerRepo.findAll();
		if (trainerList.size() > 0) {

			return trainerList;
		} else {

			throw new ListEmptyException("No Trainers to show!");
		}

	}

}
