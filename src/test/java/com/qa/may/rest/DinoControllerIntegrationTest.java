package com.qa.may.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.may.entity.Dinosaur;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
public class DinoControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	private int add(int a, int b) {
		return a + b;
	}

	@Test
	void testDemo() {
		assertEquals(2, add(1, 1));
	}

	@Test
	void testCreate() throws Exception {
		Dinosaur testDino = new Dinosaur("Terry", "T-Rex", 4494);
		String testDinoAsJSON = this.mapper.writeValueAsString(testDino);
		RequestBuilder req = post("/createDino").content(testDinoAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = MockMvcResultMatchers.status().is(201);
		Dinosaur createdDino = new Dinosaur(1, "Terry", "T-Rex", 4494);
		String createdDinoAsJSON = this.mapper.writeValueAsString(createdDino);
		ResultMatcher checkBody = MockMvcResultMatchers.content().json(createdDinoAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
}
