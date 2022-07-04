package com.qa.may.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DinoController {

	@GetMapping("/hello")
	public String helloWorld() {
		String a = "Hello, ";
		String b = "World!";
		return a + b;
	}
}
