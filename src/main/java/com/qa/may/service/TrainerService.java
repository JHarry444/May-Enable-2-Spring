package com.qa.may.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.may.dto.DinoDTO;
import com.qa.may.dto.TrainerDTO;
import com.qa.may.entity.Dinosaur;
import com.qa.may.entity.Trainer;
import com.qa.may.repo.TrainerRepo;

@Service
public class TrainerService {

	@Autowired
	private TrainerRepo repo;

	private TrainerDTO mapToDTO(Trainer trainer) {
		TrainerDTO dto = new TrainerDTO();
		dto.setId(trainer.getId());
		dto.setName(trainer.getName());

		List<DinoDTO> dinos = new ArrayList<>();
		for (Dinosaur dino : trainer.getDinos()) {
			DinoDTO dinoDTO = new DinoDTO();
			dinoDTO.setId(dino.getId());
			dinoDTO.setName(dino.getName());
			dinoDTO.setAge(dino.getAge());
			dinoDTO.setSpecies(dino.getSpecies());
			dinoDTO.setTrainerId(dino.getTrainer().getId());
			dinos.add(dinoDTO);
		}
		dto.setDinos(dinos);
		return dto;
	}

	public TrainerDTO getById(int id) {
		Trainer found = this.repo.findById(id).get();
		TrainerDTO dto = this.mapToDTO(found);
		return dto;
	}

	public List<Trainer> getAll() {
		return this.repo.findAll();
	}

	public Trainer create(Trainer trainer) {
		return this.repo.save(trainer);
	}

	public Trainer update(int id, String name) {
		Trainer toUpdate = this.repo.findById(id).get();
		if (name != null)
			toUpdate.setName(name);
		return this.repo.save(toUpdate);
	}

	public void delete(int id) {
		this.repo.deleteById(id);
	}

	public Trainer findByName(String name) {
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}

}
