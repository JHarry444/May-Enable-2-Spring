package com.qa.may.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.entity.Dinosaur;

@RestController
public class DinoController {

	private List<Dinosaur> dinos = new ArrayList<>();

	@GetMapping("/hello")
	public String helloWorld() {
		String a = "Hello, ";
		String b = "World!";
		return a + b;
	}

	@GetMapping("/demoDino")
	public Dinosaur getDemoDino() {
		return new Dinosaur("Terry", "T-Rex", Integer.MAX_VALUE);
	}

	@GetMapping("/getDino/{id}")
	public Dinosaur getById(@PathVariable int id) {
		return this.dinos.get(id);
	}

	@GetMapping("/getDinos")
	public List<Dinosaur> getAll() {
		return this.dinos;
	}

	@PostMapping("/createDino")
	public ResponseEntity<Dinosaur> create(@RequestBody Dinosaur dino) {
		System.out.println("Created: " + dino);
		this.dinos.add(dino);
		Dinosaur created = this.dinos.get(this.dinos.size() - 1);

		return new ResponseEntity<Dinosaur>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateDino/{id}")
	public Dinosaur update(@PathVariable("id") int id, @PathParam("name") String name,
			@PathParam("species") String species, @PathParam("age") Integer age) {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Species: " + species);
		System.out.println("Age: " + age);

		Dinosaur toUpdate = this.dinos.get(id);
		if (name != null)
			toUpdate.setName(name);
		if (age != null)
			toUpdate.setAge(age);
		if (species != null)
			toUpdate.setSpecies(species);
		return toUpdate;
	}

	// id = 4494
	@DeleteMapping("/removeDino/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		System.out.println("ID: " + id);
		this.dinos.remove(id);
	}
}
