package com.qa.may.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.may.entity.Dinosaur;
import com.qa.may.repo.DinoRepo;

@Service
@Primary
public class DinoServiceDB implements DinoService {

	@Autowired
	private DinoRepo repo;

	@Override
	public Dinosaur getById(int id) {
		return this.repo.findById(id).get();
	}

	@Override
	public List<Dinosaur> getAll() {
		return this.repo.findAll();
	}

	@Override
	public Dinosaur create(Dinosaur dino) {
		return this.repo.save(dino);
	}

	@Override
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

	@Override
	public void delete(int id) {
		this.repo.deleteById(id);
	}

	@Override
	public Dinosaur findByName(String name) {
		// TODO Auto-generated method stub
		return this.repo.findByNameStartingWithIgnoreCase(name);
	}

}
