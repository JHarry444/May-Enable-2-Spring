package com.qa.may.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.may.entity.Dinosaur;

@SpringBootTest
@AutoConfigureMockMvc // sets up the testing class
@Sql(scripts = { "classpath:dino-schema.sql",
		"classpath:dino-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
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

		ResultMatcher checkStatus = status().is(201);
		Dinosaur createdDino = new Dinosaur(2, "Terry", "T-Rex", 4494);
		String createdDinoAsJSON = this.mapper.writeValueAsString(createdDino);
		ResultMatcher checkBody = content().json(createdDinoAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testRead() throws Exception {
		List<Dinosaur> dinos = List.of(new Dinosaur(1, "Nessie", "Plesiosaur", 49));
		this.mvc.perform(get("/getDinos")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(dinos)));
	}

	@Test
	void testUpdate() throws Exception {
		Dinosaur updated = new Dinosaur(1, "Tiffany", "T-Rex", 4494);
		this.mvc.perform(patch("/updateDino/1?name=Tiffany&species=T-Rex&age=4494")).andExpect(status().isOk())
				.andExpect(content().json(this.mapper.writeValueAsString(updated)));
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/removeDino/1")).andExpect(status().isNoContent());
	}
}
