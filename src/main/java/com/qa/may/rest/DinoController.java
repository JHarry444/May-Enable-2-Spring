package com.qa.may.rest;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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

	@PostMapping("/createDino")
	public Dinosaur create(@RequestBody Dinosaur dino) {
		System.out.println("Created: " + dino);
		this.dinos.add(dino);
		return this.dinos.get(this.dinos.size() - 1);
	}

	@PatchMapping("/updateDino/{id}")
	public void update(@PathVariable("id") int id, @PathParam("name") String name, @PathParam("species") String species,
			@PathParam("age") int age) {
		System.out.println("ID: " + id);
		System.out.println("Name: " + name);
		System.out.println("Species: " + species);
		System.out.println("Age: " + age);
	}

	// id = 4494
	@DeleteMapping("/removeDino/{id}")
	public void delete(@PathVariable int id) {
		System.out.println("ID: " + id);
	}
}
