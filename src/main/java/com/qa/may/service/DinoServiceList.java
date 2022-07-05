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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dinosaur create(Dinosaur dino) {
		this.dinos.add(dino);
		return this.dinos.get(this.dinos.size() - 1);

	}

	@Override
	public Dinosaur update(int id, String name, String species, Integer age) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
