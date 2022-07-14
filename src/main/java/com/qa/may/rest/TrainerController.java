package com.qa.may.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.may.dto.TrainerDTO;
import com.qa.may.entity.Trainer;
import com.qa.may.service.TrainerService;

@CrossOrigin
@RestController
@RequestMapping("/trainer")
public class TrainerController {

	@Autowired
	private TrainerService service; // dependency

	@GetMapping("/hello")
	public String helloWorld() {
		String a = "Hello, ";
		String b = "World!";
		return a + b;
	}

	@GetMapping("/get/{id}")
	public TrainerDTO getById(@PathVariable int id) {
		return this.service.getById(id);
	}

	@GetMapping("/get")
	public List<Trainer> getAll() {
		return this.service.getAll();
	}

	@GetMapping("/getByName/{name}")
	public Trainer getTrainerByName(@PathVariable String name) {
		return this.service.findByName(name);
	}

	@PostMapping("/create")
	public ResponseEntity<Trainer> create(@RequestBody Trainer trainer) {
		System.out.println("Created: " + trainer);
		Trainer created = this.service.create(trainer);

		return new ResponseEntity<Trainer>(created, HttpStatus.CREATED);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
