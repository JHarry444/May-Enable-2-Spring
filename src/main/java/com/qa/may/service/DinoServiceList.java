package com.qa.may.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.qa.may.entity.Dinosaur;

@Service
@Primary
public class DinoServiceList implements DinoService {

	private List<Dinosaur> dinos = new ArrayList<>();

	@Override
	public Dinosaur getById(int id) {
		return this.dinos.get(id);

	}

	@Override
	public List<Dinosaur> getAll() {
		return this.dinos;
	}

	@Override
	public Dinosaur create(Dinosaur dino) {
		this.dinos.add(dino);
		return this.dinos.get(this.dinos.size() - 1);

	}

	@Override
	public Dinosaur update(int id, String name, String species, Integer age) {
		Dinosaur toUpdate = this.dinos.get(id);
		if (name != null)
			toUpdate.setName(name);
		if (age != null)
			toUpdate.setAge(age);
		if (species != null)
			toUpdate.setSpecies(species);
		return toUpdate;
	}

	@Override
	public void delete(int id) {
		this.dinos.remove(id);
	}

}
