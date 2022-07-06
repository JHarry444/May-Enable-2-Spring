package com.qa.may.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.qa.may.service.DinoService;

@RestController
public class DinoController {

	@Autowired
	private DinoService service; // dependency

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
		return this.service.getById(id);
	}

	@GetMapping("/getDinos")
	public List<Dinosaur> getAll() {
		return this.service.getAll();
	}

	@PostMapping("/createDino")
	public ResponseEntity<Dinosaur> create(@RequestBody Dinosaur dino) {
		System.out.println("Created: " + dino);
		Dinosaur created = this.service.create(dino);

		return new ResponseEntity<Dinosaur>(created, HttpStatus.CREATED);
	}

	@PatchMapping("/updateDino/{id}")
	public Dinosaur update(@PathVariable("id") int id, @PathParam("name") String name,
			@PathParam("species") String species, @PathParam("age") Integer age) {
		return this.update(id, name, species, age);
	}

	// id = 4494
	@DeleteMapping("/removeDino/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
