package com.qa.may.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.may.dto.DinoDTO;
import com.qa.may.entity.Dinosaur;
import com.qa.may.repo.DinoRepo;

@Service
public class DinoServiceDB {

	@Autowired
	private DinoRepo repo;

	private DinoDTO mapToDTO(Dinosaur dino) {
		DinoDTO dinoDTO = new DinoDTO();
		dinoDTO.setId(dino.getId());
		dinoDTO.setName(dino.getName());
		dinoDTO.setAge(dino.getAge());
		dinoDTO.setSpecies(dino.getSpecies());
		dinoDTO.setTrainerId(dino.getTrainer().getId());
		return dinoDTO;
	}

	public Dinosaur getById(int id) {
		return this.repo.findById(id).orElseThrow(DinoNotFoundException::new);
	}

	public List<DinoDTO> getAll() {
		this.repo.findAll().forEach(dino -> System.out.println(dino));
		this.repo.findAll().forEach(System.out::println);
//		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
		return this.repo.findAll().stream().map(dino -> this.mapToDTO(dino)).collect(Collectors.toList());

	}

	public Dinosaur create(Dinosaur dino) {
		return this.repo.save(dino);
	}

	public Dinosaur update(int id, String name, String species, Integer age) {
		Dinosaur toUpdate = this.getById(id);
		if (name != null)
			toUpdate.setName(name);
		if (age != null)
			toUpdate.setAge(age);
		if (species != null)
			toUpdate.setSpecies(species);
		return this.repo.save(toUpdate);
	}

	public void delete(int id) {
		this.repo.deleteById(id);
	}

	public Dinosaur findByName(String name) {
		// TODO Auto-generated method stub
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}

}
